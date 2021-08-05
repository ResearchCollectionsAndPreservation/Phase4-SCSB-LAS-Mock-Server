package org.recap.response;

import lombok.Data;
import org.recap.request.RetrieveItemEDDRequest;

@Data
public class GFAEddItemResponse {
    private RetrieveItemEDDRequest dsitem;
    private boolean success;
    private String screnMessage;
}
