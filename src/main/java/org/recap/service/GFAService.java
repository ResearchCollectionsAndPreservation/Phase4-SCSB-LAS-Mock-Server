package org.recap.service;


import org.recap.response.ItemStatusCheckResponse;
import org.recap.request.ItemInformationRequest;

public interface GFAService {
    ItemStatusCheckResponse itemStatus (String filter);
    public ItemInformationRequest processLASRetrieveRequest(String body);
    public ItemInformationRequest processLASEDDRetrieveRequest(String body);
}
