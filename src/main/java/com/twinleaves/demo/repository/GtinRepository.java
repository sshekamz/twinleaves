package com.twinleaves.demo.repository;

import com.twinleaves.demo.entity.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GtinRepository extends JpaRepository<Gtin, Long> {
    @Query("SELECT g FROM Gtin g JOIN g.batches b WHERE b.availableQuantity > 0")
    List<Gtin> findAllGtinsWithPositiveBatchQuantities();
}
