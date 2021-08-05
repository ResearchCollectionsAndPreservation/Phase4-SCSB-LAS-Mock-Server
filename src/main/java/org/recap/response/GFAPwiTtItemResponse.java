package org.recap.response;

import lombok.Data;

@Data
public class GFAPwiTtItemResponse {
    private String customerCode;
    private String itemBarcode;
    private String errorCode;
    private String errorNote;
}
