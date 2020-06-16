package org.recap.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.ProducerTemplate;
import org.recap.dao.LasItemTRepository;
import org.recap.dao.LasRequestItemTRepository;
import org.recap.model.LasItemT;
import org.recap.model.LasRequestItemT;
import org.recap.request.*;
import org.recap.response.*;
import org.recap.util.ReCAPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class GFAServiceImpl implements GFAService{
    @Autowired
    ProducerTemplate producerTemplate;
    @Autowired
    LasItemTRepository lasItemTRepository;
    @Autowired
    LasRequestItemTRepository lasRequestItemTRepository;
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

    @Override
    public GFAPwdResponse gfaPermanentWithdrawlDirect(GFAPwdRequest gfaPwdRequest) {

        GFAPwdResponse gfaPwdResponse = new GFAPwdResponse();
        GFAPwdTtItemRequest gfaPwdTtItemRequest = gfaPwdRequest.getDsitem().getTtitem().get(0);
        GFAPwdTtItemResponse gfaPwdTtItemResponse = new GFAPwdTtItemResponse();
        gfaPwdTtItemResponse.setCustomerCode(gfaPwdTtItemRequest.getCustomerCode());
        gfaPwdTtItemResponse.setDestination(gfaPwdTtItemRequest.getDestination());
        gfaPwdTtItemResponse.setItemBarcode(gfaPwdTtItemRequest.getItemBarcode());
        gfaPwdTtItemResponse.setRequestor(gfaPwdTtItemRequest.getRequestor());
        GFAPwdDsItemResponse gfaPwdDsItemResponse = new GFAPwdDsItemResponse();
        gfaPwdDsItemResponse.setTtitem(Arrays.asList(gfaPwdTtItemResponse));
        gfaPwdResponse.setDsitem(gfaPwdDsItemResponse);
        return gfaPwdResponse;
    }

    @Override
    public GFAPwiResponse gfaPermanentWithdrawlInDirect(GFAPwiRequest gfaPwiRequest) {

        GFAPwiResponse gfaPwiResponse = new GFAPwiResponse();
        GFAPwiTtItemRequest gfaPwiTtItemRequest = gfaPwiRequest.getDsitem().getTtitem().get(0);
        GFAPwiTtItemResponse gfaPwiTtItemResponse = new GFAPwiTtItemResponse();
        gfaPwiTtItemResponse.setItemBarcode(gfaPwiTtItemRequest.getItemBarcode());
        gfaPwiTtItemResponse.setCustomerCode(gfaPwiTtItemRequest.getCustomerCode());
        GFAPwiDsItemResponse gfaPwiDsItemResponse = new GFAPwiDsItemResponse();
        gfaPwiDsItemResponse.setTtitem(Arrays.asList(gfaPwiTtItemResponse));
        gfaPwiResponse.setDsitem(gfaPwiDsItemResponse);
        return gfaPwiResponse;
    }

    public ItemInformationRequest processLASRetrieveRequest(String body) {
        ItemInformationRequest itemInformationRequest = new ItemInformationRequest();
        LasRequestItemT lasRequestItemT = new LasRequestItemT();
        LasItemT lasItemT = new LasItemT();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GFARetrieveItemRequest gfaRetrieveItemRequest = objectMapper.readValue(body, GFARetrieveItemRequest.class);
            GFARetrieveItemResponse gfaRetrieveItemResponse = new GFARetrieveItemResponse();
            gfaRetrieveItemResponse.setSuccess(true);
            String responseJson = objectMapper.writeValueAsString(gfaRetrieveItemResponse);
            producerTemplate.sendBodyAndHeader(ReCAPConstants.LAS_INCOMING_QUEUE, responseJson, ReCAPConstants.REQUEST_TYPE_QUEUE_HEADER, ReCAPConstants.REQUEST_TYPE_RETRIEVAL);
            lasRequestItemT.setCreatedDate(new Date());
            lasRequestItemT.setRequestStatus("SUCCESS");
            lasRequestItemT.setScsbRequestId(gfaRetrieveItemRequest.getRetrieveItem().getTtitem().get(0).getRequestId());
            lasRequestItemT.setBarcode(gfaRetrieveItemRequest.getRetrieveItem().getTtitem().get(0).getItemBarcode());
            lasRequestItemTRepository.save(lasRequestItemT);
            if (lasItemTRepository.findByBarcode(itemInformationRequest.getPatronBarcode())==null)
            {
                lasItemT.setBarcode(gfaRetrieveItemRequest.getRetrieveItem().getTtitem().get(0).getItemBarcode());
                lasItemT.setStatus("OUT");
                lasItemTRepository.save(lasItemT);
            }
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