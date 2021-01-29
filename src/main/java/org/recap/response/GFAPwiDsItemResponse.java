package org.recap.response;

import java.util.List;

import lombok.Data;

@Data
public class GFAPwiDsItemResponse {
    private Boolean prodsHasChanges;
    private List<GFAPwiTtItemResponse> ttitem;
}
