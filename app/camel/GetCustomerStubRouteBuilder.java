package camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Stub to simulate customer details lookup in maxcare but providing rest endpoint on port 9998
 */
public class GetCustomerStubRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("restlet:http://localhost:9998/ocs/rest/customers/{customerId}")
                .to("stream:out")
                .choice()
                .when(header("customerId").isEqualTo("550001"))
                    .to("direct:550001")
                .when(header("customerId").isEqualTo("550002"))
                    .to("direct:550002")
                .otherwise()
                    .to("direct:notfound");

        from("direct:550001").transform().simple(XmlStrings.customer550001);
        from("direct:550002").transform().simple(XmlStrings.customer550002);
        from("direct:notfound").transform().simple(XmlStrings.customer550001);
    }
}
