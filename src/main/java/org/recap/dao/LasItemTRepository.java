package org.recap.dao;


import org.recap.model.LasItemT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LasItemTRepository extends JpaRepository<LasItemT, Integer> {
    LasItemT findByBarcode(String Barcode);
}
