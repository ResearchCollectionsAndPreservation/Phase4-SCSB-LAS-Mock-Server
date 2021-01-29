package org.recap.response;

import lombok.Data;

@Data
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
}
