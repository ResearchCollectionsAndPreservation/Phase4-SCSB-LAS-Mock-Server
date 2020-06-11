package org.recap.RecapLAS.service;


import org.recap.RecapLAS.model.ItemStatusCheckResponse;
import org.recap.RecapLAS.request.ItemInformationRequest;

public interface GFAService {
    ItemStatusCheckResponse itemStatus (String filter);
    public ItemInformationRequest processLASRetrieveRequest(String body);
    public ItemInformationRequest processLASEDDRetrieveRequest(String body);
}
