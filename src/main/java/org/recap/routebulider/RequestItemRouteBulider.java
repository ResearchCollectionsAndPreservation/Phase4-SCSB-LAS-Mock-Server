package org.recap.routebulider;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.recap.mqConsumer.RequestItemQueueConsumer;
import org.recap.service.ItemRequestService;
import org.recap.util.ReCAPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestItemRouteBulider {

    @Autowired
    public RequestItemRouteBulider(CamelContext camelContext, ItemRequestService itemRequestService) {
        try {

            camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(ReCAPConstants.LAS_OUTGOING_QUEUE)
                        .routeId(ReCAPConstants.LAS_OUTGOING_ROUTE_ID)
                        .log("LAS Outgoing Message")
                        .choice()
                        .when(header(ReCAPConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ReCAPConstants.REQUEST_TYPE_RETRIEVAL))
                        .bean(new RequestItemQueueConsumer(itemRequestService), "lasRequestRetrievalOnMessage")
                        .when(header(ReCAPConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ReCAPConstants.REQUEST_TYPE_EDD))
                        .bean(new RequestItemQueueConsumer(itemRequestService), "lasRequestEDDOnMessage");
            }
        });

    }
        catch (Exception e){
        e.printStackTrace();
        }
    }
}
