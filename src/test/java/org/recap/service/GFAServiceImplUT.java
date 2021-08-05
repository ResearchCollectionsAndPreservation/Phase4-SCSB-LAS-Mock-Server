package org.recap.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.recap.BaseTestCase;
import org.recap.response.GFAEddItemResponse;
import org.recap.response.GFARetrieveItemResponse;
import org.recap.response.RetrieveItem;
import org.recap.response.Ttitem;
import org.recap.util.ScsbConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class GFAServiceImplUT extends BaseTestCase {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void itemStatus() {
    }

    @Test
    public void processLASRetrieveRequest() throws Exception {
        GFARetrieveItemResponse gfaRetrieveItemResponse = new GFARetrieveItemResponse();
        RetrieveItem retrieveItem = new RetrieveItem();
        Ttitem ttitem = new Ttitem();
        ttitem.setItemBarcode("123456");
        retrieveItem.setTtitem(Arrays.asList(ttitem));
        gfaRetrieveItemResponse.setSuccess(true);
        gfaRetrieveItemResponse.setDsitem(retrieveItem);
        gfaRetrieveItemResponse.setScrenMessage("Message Received");
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(gfaRetrieveItemResponse);
        producerTemplate.sendBodyAndHeader(ScsbConstants.LAS_INCOMING_QUEUE, responseJson, ScsbConstants.REQUEST_TYPE_QUEUE_HEADER, ScsbConstants.REQUEST_TYPE_RETRIEVAL);
    }

    @Test
    public void processLASEDDRetrieveRequest() throws Exception {
        GFAEddItemResponse gfaEddItemResponse = new GFAEddItemResponse();
        gfaEddItemResponse.setSuccess(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(gfaEddItemResponse);
        producerTemplate.sendBodyAndHeader(ScsbConstants.LAS_INCOMING_QUEUE, responseJson, ScsbConstants.REQUEST_TYPE_QUEUE_HEADER, ScsbConstants.REQUEST_TYPE_EDD);
    }
}