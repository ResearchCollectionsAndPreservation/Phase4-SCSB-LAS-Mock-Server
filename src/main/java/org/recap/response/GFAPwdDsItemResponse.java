package org.recap.response;



import java.util.List;

public class GFAPwdDsItemResponse {

    private Boolean prodsHasChanges;

    private List<GFAPwdTtItemResponse> ttitem = null;

    public Boolean getProdsHasChanges() {
        return prodsHasChanges;
    }

    public void setProdsHasChanges(Boolean prodsHasChanges) {
        this.prodsHasChanges = prodsHasChanges;
    }

    public List<GFAPwdTtItemResponse> getTtitem() {
        return ttitem;
    }

    public void setTtitem(List<GFAPwdTtItemResponse> ttitem) {
        this.ttitem = ttitem;
    }
}
