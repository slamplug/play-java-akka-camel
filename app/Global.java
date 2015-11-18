import actors.HttpProducer;
import actors.HttpTransformer;
import actors.JmsConsumer;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.camel.Camel;
import akka.camel.CamelExtension;
import camel.GetCustomerStubRouteBuilder;
import camel.LognetNotificationStubRouteBuilder;
import org.apache.activemq.broker.BrokerService;
import org.apache.camel.CamelContext;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Akka;

import static org.apache.activemq.camel.component.ActiveMQComponent.activeMQComponent;

public class Global extends GlobalSettings {

    private static BrokerService brokerService;

    private void setupEmbeddedBroker(CamelContext camelContext) throws Exception {
        if (brokerService == null) {
            Logger.info("Starting Broker Service...");

            brokerService= new BrokerService();
            brokerService.addConnector("tcp://localhost:61616");
            brokerService.start();

            Logger.info("Starting Broker Service...OK");
        }

        Logger.info("Starting ActiveMQComponent...");

        camelContext.addComponent("activemq",
                activeMQComponent("vm://localhost?broker.persistent=false"));

        Logger.info("Starting ActiveMQComponent...OK");
    }

    private void initialiseActorSystem(CamelContext camelContext, ActorSystem actorSystem) {
        Logger.info("Initialising Actors...");

        final ActorRef httpTransformer = actorSystem.actorOf(Props.create(HttpTransformer.class, camelContext));

        final ActorRef jmsConsumer = actorSystem.actorOf(Props.create(JmsConsumer.class, httpTransformer));

        Logger.info("Initialising Actors...OK");
    }

    @Override
    public void onStart(Application app) {
        Logger.info("Application has started");

        ActorSystem system = Akka.system();
        Camel camel = CamelExtension.get(system);
        CamelContext context = camel.context();

        try {
            setupEmbeddedBroker(context);
            initialiseActorSystem(context, system);

            Logger.info("Adding Camel routes for stubs");
            context.addRoutes(new LognetNotificationStubRouteBuilder());
            context.addRoutes(new GetCustomerStubRouteBuilder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStop(Application app) {
        Logger.info("Application shutdown...");
        try {
            brokerService.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
