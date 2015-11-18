package actors;

import akka.actor.ActorRef;
import akka.camel.CamelMessage;
import akka.camel.javaapi.UntypedProducerActor;
import binding.maxcare.Customer;
import binding.maxcare.Response;
import play.Logger;
import utils.Utils;

import akka.dispatch.Futures;

// bridgeEndpoint=true makes the producer ignore the Exchange.HTTP_URI header,
// and use the endpoint's URI for request

public class HttpProducer extends UntypedProducerActor {

    private ActorRef transformer;
    private String endpointUri;

    // have to set endpoint like this as once Actor created, the endpoint is immutable
    public HttpProducer(String customerNumber) {
        this.endpointUri = "jetty://http://localhost:9998/ocs/rest/customers/" +
                customerNumber + "?bridgeEndpoint=true";
    }

    public String getEndpointUri() {
        return this.endpointUri;
    }

    @Override
    public void onRouteResponse(Object message){
        Logger.info("got http response(" + message + "), returning to sender");
        String body = ((CamelMessage)message).getBodyAs(String.class, camelContext());
        try {
            getSender().tell(parseResponse(body), getSelf());
        } catch (Exception e) {
            Futures.failed(e);
        }
    }

    private Customer parseResponse(String body) throws Exception {
        Response response = Utils.unmarshall(body, Response.class);
        //Logger.info("body: " + body);
        return response.getOk().getCustomers().getCustomerList().get(0);
    }
}
