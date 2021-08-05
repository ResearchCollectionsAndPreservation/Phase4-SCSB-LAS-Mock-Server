package org.recap.request;

import lombok.Data;

@Data
public class GFAPwdTtItemRequest {
    private String customerCode;
    private String itemBarcode;
    private String destination;
    private String requestor;
}
