package org.recap.controller;


import org.recap.request.*;
import org.recap.response.*;
import org.recap.service.GFAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lasapi/rest")
public class GFAController {
    @Autowired
    GFAService gfaService;

    @GetMapping("/lasapiSvc/itemStatus")
    public ResponseEntity<ItemStatusCheckResponse> itemStatusCheckResponse(@RequestParam String filter) {
        ItemStatusCheckResponse itemStatusCheckResponse = gfaService.itemStatus(filter);
        return new ResponseEntity<>(itemStatusCheckResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/lasapiSvc/lasStatus")
    public ResponseEntity<LasStatusCheckResponse> lasStatusCheckResponse(@RequestParam String filter) {
        LasStatusCheckResponse lasStatusCheckResponse = gfaService.lasStatus(filter);
        return new ResponseEntity<>(lasStatusCheckResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/lasapiSvc/heartBeat")
    public ResponseEntity<HeartBeatCheckResponse> heartBeatCheckResponse(@RequestParam String filter) {
        HeartBeatCheckResponse heartBeatCheckResponse = gfaService.heartBeat(filter);
        return new ResponseEntity<>(heartBeatCheckResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/lasapiSvc/retrieveItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GFARetrieveItemResponse> gfaRetrieveItem(@RequestBody GFARetrieveItemRequest gfaRetrieveItemRequest) {
        GFARetrieveItemResponse gfaRetrieveItemResponse = gfaService.gfaRetrieveItem(gfaRetrieveItemRequest);
        return new ResponseEntity<>(gfaRetrieveItemResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/lasapiSvc/retrieveEDD", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GFAEddItemResponse> gfaRetrieveEDDItem(@RequestBody GFARetrieveEDDItemRequest gfaRetrieveEDDItemRequest) {
        GFAEddItemResponse gfaEddItemResponse = gfaService.gfaRetrieveEDDItem(gfaRetrieveEDDItemRequest);
        return new ResponseEntity<>(gfaEddItemResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/lasapiSvc/permanentlyRetrieveItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GFAPwdResponse> gfaPermanentWithdrawlDirect(@RequestBody GFAPwdRequest gfaPwdRequest) {
        GFAPwdResponse gfaPwdResponse = gfaService.gfaPermanentWithdrawlDirect(gfaPwdRequest);
        return new ResponseEntity<>(gfaPwdResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/lasapiSvc/permanentlyRetrieveItemIndirect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GFAPwiResponse> gfaPwiResponseResponse(@RequestBody GFAPwiRequest gfaPwiRequest) {
        GFAPwiResponse gfaPwiResponse = gfaService.gfaPermanentWithdrawlInDirect(gfaPwiRequest);
        return new ResponseEntity<>(gfaPwiResponse, new HttpHeaders(), HttpStatus.OK);
    }
}
