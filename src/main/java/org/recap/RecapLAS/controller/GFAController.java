package org.recap.RecapLAS.controller;


import org.recap.RecapLAS.model.ItemStatusCheckResponse;
import org.recap.RecapLAS.service.GFAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lasapi/rest")
public class GFAController {
    @Autowired
    GFAService gfaService;
    @GetMapping("lasapiSvc/itemStatus")
    public ResponseEntity<ItemStatusCheckResponse> itemStatusCheckResponse(@RequestParam String filter){
        ItemStatusCheckResponse itemStatusCheckResponse = gfaService.itemStatus(filter);
        return  new ResponseEntity<ItemStatusCheckResponse>(itemStatusCheckResponse, new HttpHeaders(), HttpStatus.OK);
    }

}
