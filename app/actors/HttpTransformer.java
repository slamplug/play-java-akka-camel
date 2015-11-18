package actors;

import akka.actor.Status;
import akka.actor.UntypedActor;
import binding.maxcare.Customer;
import message.Customers;
import org.apache.camel.CamelContext;
import play.Logger;

public class HttpTransformer extends UntypedActor {

    CamelContext camelContext;

    public HttpTransformer(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public void onReceive(Object message) throws Exception {
        Logger.info("got message " + message.getClass().getName());
        if (message instanceof Customers) {
            Customers customers = (Customers) message;

            dump("MoveIn", customers.getMoveIn());
            dump("MoveOut", customers.getMoveOut());

            //getSender().tell(camelMessage, getSelf());
        } else if (message instanceof Status.Failure) {
            getSender().tell(message, getSelf());
        } else
            unhandled(message);
    }

    private void dump(String direction, Customer customer) {
        if (hasEndpoint(customer)) {
            Logger.info(direction + ": endpoint endDate: " + customer.
                    getEndpoints().
                    getEndpointList().
                    get(0).
                    getEndDate());
        } else {
            Logger.info(direction + ": no endpoints");
        }
    }

    private boolean hasEndpoint(Customer customer) {
        return (customer.getEndpoints() != null &&
                customer.getEndpoints().getEndpointList() != null &&
                customer.getEndpoints().getEndpointList().size() > 0);
    }
}
