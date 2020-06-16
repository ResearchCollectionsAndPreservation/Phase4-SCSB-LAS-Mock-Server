package org.recap.controller;


import org.recap.request.GFAPwdRequest;
import org.recap.request.GFAPwiRequest;
import org.recap.response.GFAPwdResponse;
import org.recap.response.GFAPwiResponse;
import org.recap.response.ItemStatusCheckResponse;
import org.recap.service.GFAService;
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
    @PostMapping("lasapiSvc/permanentlyRetrieveItem")
    public ResponseEntity<GFAPwdResponse> gfaPermanentWithdrawlDirect(@RequestBody GFAPwdRequest gfaPwdRequest){
        GFAPwdResponse gfaPwdResponse = gfaService.gfaPermanentWithdrawlDirect(gfaPwdRequest);
        return  new ResponseEntity<GFAPwdResponse>(gfaPwdResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("lasapiSvc/permanentlyRetrieveItemIndirect")
    public ResponseEntity<GFAPwiResponse> gfaPwiResponseResponse(@RequestBody GFAPwiRequest gfaPwiRequest){
        GFAPwiResponse gfaPwiResponse =gfaService.gfaPermanentWithdrawlInDirect(gfaPwiRequest);
        return new ResponseEntity<GFAPwiResponse>(gfaPwiResponse,new HttpHeaders(),HttpStatus.OK);
    }
}
