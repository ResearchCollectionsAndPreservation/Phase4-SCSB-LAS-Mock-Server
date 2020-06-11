package org.recap.RecapLAS.service;

import org.springframework.beans.factory.annotation.Autowired;


public class ItemRequestService {

    @Autowired
    GFAService gfaService;

    public void processLASRetrieveRequest(String body) {
        gfaService.processLASRetrieveRequest(body);
    }
    public void processLASEddRetrieveRequest(String body) {
         gfaService.processLASEDDRetrieveRequest(body);

    }

}
