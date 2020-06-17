package org.recap.model;

import javax.persistence.*;

@Entity
@Table(name = "LAS_ITEM_T", schema = "recaplas", catalog = "recaplas")
public class LasItemT {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int lasItemId;

    @Column
    private String barcode;

    @Column
    private String status;

    public LasItemT() {
    }

    public int getLasItemId() {
        return lasItemId;
    }

    public void setLasItemId(int lasItemId) {
        this.lasItemId = lasItemId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
