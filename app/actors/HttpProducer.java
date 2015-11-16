package actors;

import akka.actor.ActorRef;
import akka.camel.javaapi.UntypedProducerActor;
import play.Logger;

// bridgeEndpoint=true makes the producer ignore the Exchange.HTTP_URI header,
// and use the endpoint's URI for request

public class HttpProducer extends UntypedProducerActor {

    private ActorRef transformer;
    private String endpointUri;

    // have to set endpoint like this as once Actor created, the endpoint is immutable
    public HttpProducer(ActorRef transformer, String customerNumber) {
        this.transformer = transformer;
        this.endpointUri = "jetty://http://localhost:9998/ocs/rest/customers/" +
                customerNumber + "?bridgeEndpoint=true";
    }

    public String getEndpointUri() {
        return this.endpointUri;
    }

    @Override
    public void onRouteResponse(Object message) {
        Logger.info("Got response (" + message + "), forward to transformer actor");
        transformer.forward(message, getContext());
    }
}
