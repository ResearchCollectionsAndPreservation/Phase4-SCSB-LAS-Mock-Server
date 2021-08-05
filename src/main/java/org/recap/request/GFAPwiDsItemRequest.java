package org.recap.request;

import lombok.Data;

import java.util.List;

@Data
public class GFAPwiDsItemRequest {
    private List<GFAPwiTtItemRequest> ttitem;
}
