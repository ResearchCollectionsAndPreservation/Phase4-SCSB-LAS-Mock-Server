package org.recap.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "LAS_ITEM_T", schema = "recaplas", catalog = "recaplas")
public class LasItemT {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lasItemId;

    @Column
    private String barcode;

    @Column
    private String status;
}
