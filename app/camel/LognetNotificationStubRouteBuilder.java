package camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Stub route to put message onto queue every 60s. Simulates COTS plain lognet notifications
 */

public class LognetNotificationStubRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("timer://simpleTimer?period=60000")
                .setBody(simple(XmlStrings.plainCotXml))
                //.to("stream:out")
                .to("activemq:queue:test.queue");
    }
}
