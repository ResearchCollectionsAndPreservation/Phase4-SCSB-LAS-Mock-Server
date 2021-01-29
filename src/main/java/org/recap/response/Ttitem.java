package org.recap.response;

import lombok.Data;

@Data
public class Ttitem {
    private String itemBarcode;
    private String itemStatus;
    private String customerCode;
    private String destination;
    private String deliveryMethod;
    private String requestDate;
    private String requestTime;
    private String errorCode;
    private String errorNote;
    private Integer requestId;
    private String requestor;
    private String requestorFirstName;
    private String requestorLastName;
    private String requestorMiddleName;
    private String requestorEmail;
    private String requestorOther;
    private String biblioTitle;
    private String biblioLocation;
    private String biblioAuthor;
    private String biblioVolume;
    private String biblioCode;
    private String articleTitle;
    private String articleAuthor;
    private String articleVolume;
    private String articleIssue;
    private String articleDate;
    private String startPage;
    private String endPage;
    private String pages;
    private String other;
    private String priority;
    private String notes;
}
