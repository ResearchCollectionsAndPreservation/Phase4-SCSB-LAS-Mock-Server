package org.recap.response;

import lombok.Data;

@Data
public class GFARetrieveItemResponse {
    private RetrieveItem dsitem;
    private boolean success;
    private String screnMessage;
}
