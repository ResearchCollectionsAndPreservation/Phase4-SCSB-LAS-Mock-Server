package org.recap.RecapLAS.request;

import java.util.List;

public class RetrieveItemEDDRequest {
    private List<TtitemEDDResponse> ttitem;

    public List<TtitemEDDResponse> getTtitem() {
        return ttitem;
    }

    public void setTtitem(List<TtitemEDDResponse> ttitem) {
        this.ttitem = ttitem;
    }
}
