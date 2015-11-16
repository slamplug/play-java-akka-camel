package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.camel.CamelMessage;
import akka.camel.javaapi.UntypedConsumerActor;
import binding.lognet.Communication;
import org.apache.camel.Exchange;
import play.Logger;
import play.libs.Akka;
import utils.Utils;

import java.util.HashMap;

public class JmsConsumer extends UntypedConsumerActor {

    private ActorRef transformer;

    public JmsConsumer(ActorRef transformer) {
        this.transformer = transformer;
    }

    public String getEndpointUri() {
        return "activemq:queue:test.queue";
    }

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

            communication.getCustomers().getCustomerList().forEach(customer -> {
                Logger.info("call HttpProducer actor for customer: " +
                        customer.getCustomerNumber());
                // have to create an actor per customer as customer number is part of
                // end point URL. Once Actor created the endpoint is immutable.
                ActorRef producer = Akka.system().actorOf(Props.create(
                        HttpProducer.class, transformer, customer.getCustomerNumber()));
                // tell, don't wait for response. Set header to GET (default POST)
                producer.tell(camelMessage.withHeaders(new HashMap<String, Object>() {{
                    put(Exchange.HTTP_METHOD, "GET");
                }}), null);
            });
        } else {
            unhandled(message);
        }
    }
}