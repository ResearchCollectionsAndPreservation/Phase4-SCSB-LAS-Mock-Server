package org.recap.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GFAPwdTtItemResponse {

    private String customerCode;

    private String itemBarcode;

    private String destination;

    private Object deliveryMethod;

    private String requestor;

    private Object requestorFirstName;

    private Object requestorLastName;

    private Object requestorMiddleName;

    private Object requestorEmail;

    private Object requestorOther;

    private Object priority;

    private Object notes;

    private Object requestDate;

    private Object requestTime;

    private Object errorCode;

    private Object errorNote;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Object getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Object deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public Object getRequestorFirstName() {
        return requestorFirstName;
    }

    public void setRequestorFirstName(Object requestorFirstName) {
        this.requestorFirstName = requestorFirstName;
    }

    public Object getRequestorLastName() {
        return requestorLastName;
    }

    public void setRequestorLastName(Object requestorLastName) {
        this.requestorLastName = requestorLastName;
    }

    public Object getRequestorMiddleName() {
        return requestorMiddleName;
    }

    public void setRequestorMiddleName(Object requestorMiddleName) {
        this.requestorMiddleName = requestorMiddleName;
    }

    public Object getRequestorEmail() {
        return requestorEmail;
    }

    public void setRequestorEmail(Object requestorEmail) {
        this.requestorEmail = requestorEmail;
    }

    public Object getRequestorOther() {
        return requestorOther;
    }

    public void setRequestorOther(Object requestorOther) {
        this.requestorOther = requestorOther;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Object requestDate) {
        this.requestDate = requestDate;
    }

    public Object getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Object requestTime) {
        this.requestTime = requestTime;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorNote() {
        return errorNote;
    }

    public void setErrorNote(Object errorNote) {
        this.errorNote = errorNote;
    }
}
