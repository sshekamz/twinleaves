package com.twinleaves.demo.repository;
import com.twinleaves.demo.entity.Gtin;
import com.twinleaves.demo.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {
//    @Query("SELECT b FROM Batch b WHERE b.availableQuantity > 0")
//    List<Batch> findPositiveAvailableQuantity();

    @Query("SELECT b FROM Batch b WHERE b.availableQuantity <= 0 ORDER BY b.inwardedOn DESC")
    List<Batch> findLatestBatchWithNonPositiveQuantity();

    @Query("SELECT DISTINCT g FROM Gtin g JOIN g.batches b WHERE b.availableQuantity > 0")
    List<Gtin> findGtinsWithPositiveBatches();



}
