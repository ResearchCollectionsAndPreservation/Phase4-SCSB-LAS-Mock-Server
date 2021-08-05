package org.recap.service;


import org.recap.request.*;
import org.recap.response.*;

public interface GFAService {
    ItemStatusCheckResponse itemStatus(String filter);

    LasStatusCheckResponse lasStatus(String filter);

    HeartBeatCheckResponse heartBeat(String filter);

    GFAPwdResponse gfaPermanentWithdrawlDirect(GFAPwdRequest gfaPwdRequest);

    GFAPwiResponse gfaPermanentWithdrawlInDirect(GFAPwiRequest gfaPwiRequest);

    public ItemInformationRequest processLASRetrieveRequest(String body);

    public ItemInformationRequest processLASEDDRetrieveRequest(String body);

    GFARetrieveItemResponse gfaRetrieveItem(GFARetrieveItemRequest gfaRetrieveItemRequest);

    GFAEddItemResponse gfaRetrieveEDDItem(GFARetrieveEDDItemRequest gfaRetrieveEDDItemRequest);
}
