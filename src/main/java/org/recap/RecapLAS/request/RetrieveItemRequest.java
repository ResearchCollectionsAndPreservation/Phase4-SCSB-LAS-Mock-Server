package org.recap.RecapLAS.request;

import java.util.List;

public class RetrieveItemRequest {

    private List<TtitemRequest> ttitem;

    public List<TtitemRequest> getTtitem() {
        return ttitem;
    }

    public void setTtitem(List<TtitemRequest> ttitem) {
        this.ttitem = ttitem;
    }
}
