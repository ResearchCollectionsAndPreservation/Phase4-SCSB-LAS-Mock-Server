package org.recap.response;

import lombok.Data;

import java.util.List;

@Data
public class GFAPwdDsItemResponse {
    private Boolean prodsHasChanges;
    private List<GFAPwdTtItemResponse> ttitem;
}
