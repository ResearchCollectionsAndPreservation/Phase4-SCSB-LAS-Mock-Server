package org.recap.service;


import org.recap.request.GFAPwdRequest;
import org.recap.request.GFAPwiRequest;
import org.recap.response.GFAPwdResponse;
import org.recap.response.GFAPwiResponse;
import org.recap.response.ItemStatusCheckResponse;
import org.recap.request.ItemInformationRequest;

public interface GFAService {
    ItemStatusCheckResponse itemStatus (String filter);
    GFAPwdResponse gfaPermanentWithdrawlDirect(GFAPwdRequest gfaPwdRequest);
    GFAPwiResponse gfaPermanentWithdrawlInDirect(GFAPwiRequest gfaPwiRequest);
    public ItemInformationRequest processLASRetrieveRequest(String body);
    public ItemInformationRequest processLASEDDRetrieveRequest(String body);
}
