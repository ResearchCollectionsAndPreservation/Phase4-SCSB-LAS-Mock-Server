package org.recap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
