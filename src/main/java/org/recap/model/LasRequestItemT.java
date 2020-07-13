package org.recap.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "LAS_REQUEST_ITEM_T", schema = "recaplas", catalog = "recaplas")
public class LasRequestItemT {
    @Id
    @Column(name = "LAS_REQUEST_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lasRequestItemId;

    @Column(name = "SCSB_REQUEST_ID")
    private String scsbRequestId;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "REQUEST_STATUS_CODE")
    private String requestStatus;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    public LasRequestItemT() {
    }

    public int getLasRequestItemId() {
        return lasRequestItemId;
    }

    public void setLasRequestItemId(int lasRequestItemId) {
        this.lasRequestItemId = lasRequestItemId;
    }

    public String getScsbRequestId() {
        return scsbRequestId;
    }

    public void setScsbRequestId(String scsbRequestId) {
        this.scsbRequestId = scsbRequestId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}