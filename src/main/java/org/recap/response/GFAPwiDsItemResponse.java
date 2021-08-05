package org.recap.response;

import lombok.Data;

import java.util.List;

@Data
public class GFAPwiDsItemResponse {
    private Boolean prodsHasChanges;
    private List<GFAPwiTtItemResponse> ttitem;
}
