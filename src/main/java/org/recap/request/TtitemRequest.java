package org.recap.request;

import lombok.Data;

@Data
public class TtitemRequest {
    private String itemBarcode;
    private String itemStatus;
    private String customerCode;
    private String destination;
    private String requestId;
    private String requestor;
}
