package actors;

import akka.actor.Status;
import akka.actor.UntypedActor;
import akka.camel.CamelMessage;
import binding.maxcare.Customer;
import binding.maxcare.Response;
import org.apache.camel.CamelContext;
import play.Logger;
import utils.Utils;

public class HttpTransformer extends UntypedActor {

    CamelContext camelContext;

    public HttpTransformer(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public void onReceive(Object message) throws Exception {
        Logger.info("got message");
        if (message instanceof CamelMessage) {
            CamelMessage camelMessage = (CamelMessage) message;

            String body = camelMessage.getBodyAs(String.class, this.camelContext);
            Response response = Utils.unmarshall(body, Response.class);
            Logger.info("body: " + body);

            Customer customer = response.getOk().getCustomers().getCustomerList().get(0);

            if (hasEndpoint(customer)) {
                Logger.info("endpoint endDate: " + customer.
                        getEndpoints().
                        getEndpointList().
                        get(0).
                        getEndDate());
            } else {
                Logger.info("no endpoints");
            }

            //getSender().tell(camelMessage, getSelf());
        } else if (message instanceof Status.Failure) {
            getSender().tell(message, getSelf());
        } else
            unhandled(message);
    }

    private boolean hasEndpoint(Customer customer) {
        return (customer.getEndpoints() != null &&
                customer.getEndpoints().getEndpointList() != null &&
                customer.getEndpoints().getEndpointList().size() > 0);
    }
}
