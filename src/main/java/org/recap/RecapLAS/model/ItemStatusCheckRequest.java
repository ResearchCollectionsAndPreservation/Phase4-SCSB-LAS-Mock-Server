package org.recap.RecapLAS.model;

import java.util.List;

public class ItemStatusCheckRequest {

    private List<ItemStatus> itemStatus;

    /**
     * Gets item status.
     *
     * @return the item status
     */
    public List<ItemStatus> getItemStatus() {
        return itemStatus;
    }

    /**
     * Sets item status.
     *
     * @param itemStatus the item status
     */
    public void setItemStatus(List<ItemStatus> itemStatus) {
        this.itemStatus = itemStatus;
    }
}
