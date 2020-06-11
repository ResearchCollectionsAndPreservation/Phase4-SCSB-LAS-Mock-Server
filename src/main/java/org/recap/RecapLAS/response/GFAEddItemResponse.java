package org.recap.RecapLAS.response;


import org.recap.RecapLAS.request.RetrieveItemEDDRequest;

public class GFAEddItemResponse {
    private boolean success;
    private String screnMessage;
    private RetrieveItemEDDRequest retrieveEDD;

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

    public RetrieveItemEDDRequest getRetrieveEDD() {
        return retrieveEDD;
    }

    public void setRetrieveEDD(RetrieveItemEDDRequest retrieveEDD) {
        this.retrieveEDD = retrieveEDD;
    }
}
