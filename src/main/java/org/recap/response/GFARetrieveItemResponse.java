package org.recap.response;

public class GFARetrieveItemResponse {
    private RetrieveItem retrieveItem;
    private boolean success;
    private String screnMessage;

    public RetrieveItem getRetrieveItem() {
        return retrieveItem;
    }

    public void setRetrieveItem(RetrieveItem retrieveItem) {
        this.retrieveItem = retrieveItem;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getScrenMessage() {
        return screnMessage;
    }

    public void setScrenMessage(String screnMessage) {
        this.screnMessage = screnMessage;
    }
}
