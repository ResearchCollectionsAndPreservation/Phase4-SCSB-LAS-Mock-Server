package org.recap.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.recap.dao.LasItemTRepository;
import org.recap.dao.LasRequestItemTRepository;
import org.recap.model.LasItemT;
import org.recap.model.LasRequestItemT;
import org.recap.request.*;
import org.recap.response.*;
import org.recap.util.ScsbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GFAServiceImpl implements GFAService {
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

            List<ItemStatus> itemStatus = itemStatusCheckRequest.getItemStatus();
            Dsitem dsitem = new Dsitem();
            Ttitem ttitem = new Ttitem();
            ttitem.setItemBarcode(itemStatus.get(0).getItemBarCode());
            ttitem.setItemStatus("IN");
            dsitem.setTtitem(Collections.singletonList(ttitem));
            itemStatusCheckResponse.setDsitem(dsitem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemStatusCheckResponse;
    }

    public LasStatusCheckResponse lasStatus(String filter) {
        LasStatusCheckResponse lasStatusCheckResponse = new LasStatusCheckResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LasStatusCheckRequest lasStatusCheckRequest = objectMapper.readValue(filter, LasStatusCheckRequest.class);
            List<LasStatus> lasStatus = lasStatusCheckRequest.getLasStatus();
            String imsLocationCode = lasStatus.get(0).getImsLocationCode();

            LasStatusDsItem dsitem = new LasStatusDsItem();
            LasStatusTtItem ttitem = new LasStatusTtItem();
            ttitem.setImsLocationCode(imsLocationCode);
            if (!imsLocationCode.equalsIgnoreCase("RECAP")) {
                ttitem.setSuccess(Boolean.FALSE.toString());
                ttitem.setScreenMessage("Invalid Location: " + imsLocationCode);
            } else {
                ttitem.setSuccess(Boolean.TRUE.toString());
                ttitem.setScreenMessage("");
            }
            dsitem.setTtitem(Collections.singletonList(ttitem));
            lasStatusCheckResponse.setDsitem(dsitem);
            log.info("Las Status Response: {}", objectMapper.writeValueAsString(lasStatusCheckResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lasStatusCheckResponse;
    }

    public HeartBeatCheckResponse heartBeat(String filter) {
        HeartBeatCheckResponse heartBeatCheckResponse = new HeartBeatCheckResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HeartBeatCheckRequest heartBeatCheckRequest = objectMapper.readValue(filter, HeartBeatCheckRequest.class);
            String imsLocationCode = heartBeatCheckRequest.getImsLocationCode();
            log.info("IMS Location : {}", imsLocationCode);
            heartBeatCheckResponse.setSuccess(true);
            heartBeatCheckResponse.setScreenMessage("");
            if (!imsLocationCode.equalsIgnoreCase("RECAP")) {
                heartBeatCheckResponse.setSuccess(false);
                heartBeatCheckResponse.setScreenMessage("Invalid Location: " + imsLocationCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return heartBeatCheckResponse;
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
        gfaPwdDsItemResponse.setTtitem(Collections.singletonList(gfaPwdTtItemResponse));
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
        gfaPwiDsItemResponse.setTtitem(Collections.singletonList(gfaPwiTtItemResponse));
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
            RetrieveItem retrieveItem = new RetrieveItem();
            Ttitem ttitem = new Ttitem();
            ttitem.setItemBarcode(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getItemBarcode());
            ttitem.setRequestId(Integer.parseInt(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getRequestId()));
            ttitem.setCustomerCode(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getCustomerCode());
            ttitem.setItemStatus(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getItemStatus());
            ttitem.setDestination(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getDestination());
            ttitem.setRequestor(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getRequestor());
            retrieveItem.setTtitem(Collections.singletonList(ttitem));
            gfaRetrieveItemResponse.setDsitem(retrieveItem);
            gfaRetrieveItemResponse.setSuccess(true);
            gfaRetrieveItemResponse.setScrenMessage("Las Processed Request Successfully");
            String responseJson = objectMapper.writeValueAsString(gfaRetrieveItemResponse);
            lasRequestItemT.setCreatedDate(new Date());
            lasRequestItemT.setRequestStatus("SUCCESS");
            lasRequestItemT.setScsbRequestId(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getRequestId());
            lasRequestItemT.setBarcode(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getItemBarcode());
            lasRequestItemTRepository.save(lasRequestItemT);
            if (lasItemTRepository.findByBarcode(itemInformationRequest.getPatronBarcode()) != null) {
                lasItemT.setStatus("OUT");
            } else {
                lasItemT.setBarcode(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getItemBarcode());
                lasItemT.setStatus("OUT");
                lasItemTRepository.save(lasItemT);
            }

            producerTemplate.sendBodyAndHeader(ScsbConstants.LAS_INCOMING_QUEUE, responseJson, ScsbConstants.REQUEST_TYPE_QUEUE_HEADER, ScsbConstants.REQUEST_TYPE_RETRIEVAL);
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
            RetrieveItemEDDRequest retrieveEdd = new RetrieveItemEDDRequest();
            TtitemEDDResponse ttitem = new TtitemEDDResponse();
            ttitem.setItemBarcode(gfaEddItemRequest.getDsitem().getTtitem().get(0).getItemBarcode());
            ttitem.setRequestId(gfaEddItemRequest.getDsitem().getTtitem().get(0).getRequestId());
            ttitem.setErrorCode("");
            ttitem.setErrorNote("");
            retrieveEdd.setTtitem(Collections.singletonList(ttitem));
            gfaEddItemResponse.setDsitem(retrieveEdd);
            gfaEddItemResponse.setSuccess(true);
            gfaEddItemResponse.setScrenMessage("Las Processed EDD Request Successfully");
            String responseJson = om.writeValueAsString(gfaEddItemResponse);

            producerTemplate.sendBodyAndHeader(ScsbConstants.LAS_INCOMING_QUEUE, responseJson, ScsbConstants.REQUEST_TYPE_QUEUE_HEADER, ScsbConstants.REQUEST_TYPE_EDD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemInformationRequest;
    }

    @Override
    public GFARetrieveItemResponse gfaRetrieveItem(GFARetrieveItemRequest gfaRetrieveItemRequest) {
        GFARetrieveItemResponse gfaRetrieveItemResponse = new GFARetrieveItemResponse();
        RetrieveItem retrieveItem = new RetrieveItem();
        Ttitem ttitem = new Ttitem();
        ttitem.setItemBarcode(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getItemBarcode());
        ttitem.setRequestId(Integer.parseInt(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getRequestId()));
        ttitem.setCustomerCode(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getCustomerCode());
        ttitem.setItemStatus(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getItemStatus());
        ttitem.setDestination(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getDestination());
        ttitem.setRequestor(gfaRetrieveItemRequest.getDsitem().getTtitem().get(0).getRequestor());
        retrieveItem.setTtitem(Collections.singletonList(ttitem));
        gfaRetrieveItemResponse.setDsitem(retrieveItem);
        gfaRetrieveItemResponse.setSuccess(true);
        gfaRetrieveItemResponse.setScrenMessage("Las Processed Request Successfully");
        return gfaRetrieveItemResponse;
    }

    @Override
    public GFAEddItemResponse gfaRetrieveEDDItem(GFARetrieveEDDItemRequest gfaRetrieveEDDItemRequest) {
        GFAEddItemResponse gfaEddItemResponse = new GFAEddItemResponse();
        RetrieveItemEDDRequest retrieveEdd = new RetrieveItemEDDRequest();
        TtitemEDDResponse ttitem = new TtitemEDDResponse();
        ttitem.setItemBarcode(gfaRetrieveEDDItemRequest.getDsitem().getTtitem().get(0).getItemBarcode());
        ttitem.setRequestId(gfaRetrieveEDDItemRequest.getDsitem().getTtitem().get(0).getRequestId());
        ttitem.setErrorCode("");
        ttitem.setErrorNote("");
        retrieveEdd.setTtitem(Collections.singletonList(ttitem));
        gfaEddItemResponse.setDsitem(retrieveEdd);
        gfaEddItemResponse.setSuccess(true);
        gfaEddItemResponse.setScrenMessage("Las Processed EDD Request Successfully");
        return gfaEddItemResponse;
    }

    private String DateFormat() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        return formatter.format(date);
    }

}
