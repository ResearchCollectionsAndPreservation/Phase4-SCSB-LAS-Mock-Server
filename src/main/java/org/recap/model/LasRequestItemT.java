package org.recap.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "las_request_item_t")
public class LasRequestItemT {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lasRequestItemId;

    @Column
    private String scsbRequestId;

    @Column
    private String barcode;

    @Column
    private String requestStatus;

    @Column
    private String createdDate;

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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}