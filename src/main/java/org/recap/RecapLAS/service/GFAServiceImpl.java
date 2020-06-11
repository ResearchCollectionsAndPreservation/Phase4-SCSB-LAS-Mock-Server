package org.recap.RecapLAS.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.ProducerTemplate;
import org.recap.RecapLAS.model.*;
import org.recap.RecapLAS.request.GFAEddItemRequest;
import org.recap.RecapLAS.request.GFARetrieveItemRequest;
import org.recap.RecapLAS.request.ItemInformationRequest;
import org.recap.RecapLAS.response.GFAEddItemResponse;
import org.recap.RecapLAS.response.GFARetrieveItemResponse;
import org.recap.RecapLAS.util.ReCAPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GFAServiceImpl implements GFAService{
    @Autowired
    ProducerTemplate producerTemplate;
    public ItemStatusCheckResponse itemStatus(String filter) {

        ItemStatusCheckResponse itemStatusCheckResponse = new ItemStatusCheckResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ItemStatusCheckRequest itemStatusCheckRequest = objectMapper.readValue(filter, ItemStatusCheckRequest.class);

        List<ItemStatus> itemStatus =itemStatusCheckRequest.getItemStatus();
        Dsitem dsitem =new Dsitem();
        Ttitem ttitem = new Ttitem();
        ttitem.setItemBarcode(itemStatus.get(0).getItemBarCode());
        ttitem.setItemStatus("IN");
        dsitem.setTtitem(Arrays.asList(ttitem));
        itemStatusCheckResponse.setDsitem(dsitem);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemStatusCheckResponse;
    }
    public ItemInformationRequest processLASRetrieveRequest(String body) {
        ItemInformationRequest itemInformationRequest = new ItemInformationRequest();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GFARetrieveItemRequest gfaRetrieveItemRequest = objectMapper.readValue(body, GFARetrieveItemRequest.class);
            GFARetrieveItemResponse gfaRetrieveItemResponse = new GFARetrieveItemResponse();
            gfaRetrieveItemResponse.setSuccess(true);
            String responseJson = objectMapper.writeValueAsString(gfaRetrieveItemResponse);
            producerTemplate.sendBodyAndHeader(ReCAPConstants.LAS_INCOMING_QUEUE, responseJson, ReCAPConstants.REQUEST_TYPE_QUEUE_HEADER, ReCAPConstants.REQUEST_TYPE_RETRIEVAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemInformationRequest;
    }

    @Override
    public ItemInformationRequest processLASEDDRetrieveRequest(String body) {
        ItemInformationRequest itemInformationRequest = new ItemInformationRequest();
        ObjectMapper om = new ObjectMapper();
        try {
            GFAEddItemRequest gfaEddItemRequest = om.readValue(body, GFAEddItemRequest.class);
            GFAEddItemResponse gfaEddItemResponse = new GFAEddItemResponse();
            gfaEddItemResponse.setSuccess(true);
            String responseJson = om.writeValueAsString(gfaEddItemResponse);
            producerTemplate.sendBodyAndHeader(ReCAPConstants.LAS_INCOMING_QUEUE, responseJson, ReCAPConstants.REQUEST_TYPE_QUEUE_HEADER, ReCAPConstants.REQUEST_TYPE_RETRIEVAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemInformationRequest;
    }



}
