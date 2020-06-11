package org.recap.RecapLAS.response;



import org.recap.RecapLAS.model.Ttitem;

import java.util.List;

public class RetrieveItem {
    private List<Ttitem> ttitem;

    public List<Ttitem> getTtitem() {
        return ttitem;
    }

    public void setTtitem(List<Ttitem> ttitem) {
        this.ttitem = ttitem;
    }
}
