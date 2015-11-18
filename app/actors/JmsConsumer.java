package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.camel.CamelMessage;
import akka.camel.javaapi.UntypedConsumerActor;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.util.Timeout;
import binding.lognet.Communication;
import binding.maxcare.Customer;
import message.Customers;
import org.apache.camel.Exchange;
import play.Logger;
import play.libs.Akka;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;
import static akka.pattern.Patterns.pipe;

public class JmsConsumer extends UntypedConsumerActor {

    private ActorRef transformer;

    public JmsConsumer(ActorRef transformer) {
        this.transformer = transformer;
    }

    public String getEndpointUri() {
        return "activemq:queue:test.queue";
    }

    final Timeout t = new Timeout(Duration.create(5, TimeUnit.SECONDS));

    final ActorSystem system = Akka.system();

    @Override
    public boolean autoAck() {
        return true;
    }

    public void onReceive(Object message) throws Exception {
        Logger.info("got jms message");
        if (message instanceof CamelMessage) {
            CamelMessage camelMessage = (CamelMessage) message;
            String body = camelMessage.getBodyAs(
                    String.class, getCamelContext());
            Communication communication = Utils.unmarshall(body, Communication.class);

            final ArrayList<Future<Object>> futures = new ArrayList<Future<Object>>();
            communication.getCustomers().getCustomerList().forEach(customer -> {
                futures.add(ask(getHttpProducerRef(customer.getCustomerNumber()),
                        camelMessage.withHeaders(new HashMap<String, Object>() {{
                            put(Exchange.HTTP_METHOD, "GET");
                        }}), t));
            });
            final Future<Iterable<Object>> aggregate = Futures.sequence(futures,
                    system.dispatcher());

            final Future<Customers> customers = aggregate.map(
                new Mapper<Iterable<Object>, Customers>() {
                        public Customers apply(Iterable<Object> coll) {
                            final Iterator<Object> it = coll.iterator();
                            final Customer x = (Customer) it.next();
                            final Customer s = (Customer) it.next();
                            return new Customers(x, s);
                        }
                    }, system.dispatcher());

            Logger.debug("customers " + customers);
            pipe(customers, system.dispatcher()).to(transformer);
        } else {
            unhandled(message);
        }
    }

    // have to create an actor per customer as customer number is part of
    // end point URL. Once Actor created the endpoint is immutable.
    private ActorRef getHttpProducerRef(String customerNumber) {
        return Akka.system().actorOf(
                Props.create(
                        HttpProducer.class,
                        customerNumber));
    }
}