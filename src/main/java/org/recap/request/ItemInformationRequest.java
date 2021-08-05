package org.recap.request;

import lombok.Data;

import java.util.List;

@Data
public class ItemInformationRequest {
    private Integer requestId;
    private String expirationDate;
    private String titleIdentifier;
    private String dueDate;
    private String circulationStatus;
    private String securityMarker;
    private String feeType;
    private String transactionDate;
    private String holdQueueLength = "0";
    private String holdPickupDate;
    private String recallDate;
    private String Owner;
    private String mediaType;
    private String permanentLocation;
    private String currentLocation;
    private String bibID;
    private String ISBN;
    private String LCCN;
    private String currencyType;
    private String callNumber;
    private String itemType;
    private List<String> bibIds;
    private String source;
    private String createdDate;
    private String updatedDate;
    private String deletedDate;
    private boolean isDeleted;
    private String patronBarcode = "";
    private String requestingInstitution = "";
    private String emailAddress = "";
    private String requestType = ""; // Retrieval,EDD, Hold, Recall, Borrow Direct
    private String deliveryLocation = "";
    private String requestNotes = "";
    private Integer itemId;
    private String username;
    private boolean isBulk;
    private boolean requestTypeForScheduledOnWO;
    private String eddSuccessResponseScreenMsg;
    private String eddFailureResponseScreenMsg;
}
