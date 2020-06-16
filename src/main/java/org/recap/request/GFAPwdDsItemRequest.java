package org.recap.request;

import java.util.List;

public class GFAPwdDsItemRequest {

    private List<GFAPwdTtItemRequest> ttitem = null;

    public List<GFAPwdTtItemRequest> getTtitem() {
        return ttitem;
    }

    public void setTtitem(List<GFAPwdTtItemRequest> ttitem) {
        this.ttitem = ttitem;
    }
}
