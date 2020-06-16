package org.recap.response;



import java.util.List;

public class GFAPwiDsItemResponse {

    private Boolean prodsHasChanges;

    private List<GFAPwiTtItemResponse> ttitem = null;

    public Boolean getProdsHasChanges() {
        return prodsHasChanges;
    }

    public void setProdsHasChanges(Boolean prodsHasChanges) {
        this.prodsHasChanges = prodsHasChanges;
    }

    public List<GFAPwiTtItemResponse> getTtitem() {
        return ttitem;
    }

    public void setTtitem(List<GFAPwiTtItemResponse> ttitem) {
        this.ttitem = ttitem;
    }
}
