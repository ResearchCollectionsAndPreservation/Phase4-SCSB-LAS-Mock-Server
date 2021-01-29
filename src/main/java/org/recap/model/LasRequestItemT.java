package org.recap.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
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
}