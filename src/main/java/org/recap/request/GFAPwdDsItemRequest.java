package org.recap.request;

import lombok.Data;

import java.util.List;

@Data
public class GFAPwdDsItemRequest {
    private List<GFAPwdTtItemRequest> ttitem;
}
