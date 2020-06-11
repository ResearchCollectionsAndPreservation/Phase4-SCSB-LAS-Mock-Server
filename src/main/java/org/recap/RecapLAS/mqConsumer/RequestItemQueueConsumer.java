package org.recap.RecapLAS.mqConsumer;


import org.apache.camel.Body;
import org.recap.RecapLAS.service.ItemRequestService;

public class RequestItemQueueConsumer {


    private ItemRequestService itemRequestService;

    public ItemRequestService getItemRequestService() {
        return itemRequestService;
    }

    public RequestItemQueueConsumer(ItemRequestService itemRequestService) {
        this.itemRequestService = itemRequestService;
    }
    public void lasRequestRetrievalOnMessage(@Body String body) {
        getItemRequestService().processLASRetrieveRequest(body);
    }
    public void lasRequestEDDOnMessage(@Body String body) {
        getItemRequestService().processLASEddRetrieveRequest(body);
    }


}
