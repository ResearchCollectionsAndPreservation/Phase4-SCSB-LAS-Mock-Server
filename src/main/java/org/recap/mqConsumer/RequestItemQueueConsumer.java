package org.recap.mqConsumer;


import org.apache.camel.Body;
import org.recap.service.ItemRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RequestItemQueueConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RequestItemQueueConsumer.class);

    private ItemRequestService itemRequestService;

    public ItemRequestService getItemRequestService() {
        return itemRequestService;
    }

    public RequestItemQueueConsumer(ItemRequestService itemRequestService) {
        this.itemRequestService = itemRequestService;
    }
    public void lasRequestRetrievalOnMessage(@Body String body) {
        logger.info("Scsb Retrieval Message: {}", body);
        getItemRequestService().processLASRetrieveRequest(body);
    }
    public void lasRequestEDDOnMessage(@Body String body) {
        getItemRequestService().processLASEddRetrieveRequest(body);
    }


}
