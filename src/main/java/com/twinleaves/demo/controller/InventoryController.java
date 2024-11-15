package com.twinleaves.demo.controller;

import com.twinleaves.demo.entity.Batch;
import com.twinleaves.demo.entity.Gtin;
import com.twinleaves.demo.entity.Product;
import com.twinleaves.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // POST endpoint to create a new Product
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = inventoryService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // POST endpoint to create a new GTIN
    @PostMapping("/gtin")
    public ResponseEntity<Gtin> createGtin(@RequestBody Gtin gtin) {
        Gtin savedGtin = inventoryService.createGtin(gtin);
        return ResponseEntity.ok(savedGtin);
    }

    // POST endpoint to create a new Batch
    @PostMapping("/batch")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
        Batch savedBatch = inventoryService.createBatch(batch);
        return ResponseEntity.ok(savedBatch);
    }

    // GET endpoint to retrieve GTINs with batches having positive available quantities
    @GetMapping("/gtins/positive-quantity")
    public ResponseEntity<List<Gtin>> getGtinsWithPositiveQuantities() {
        List<Gtin> gtins = inventoryService.getGtinsWithPositiveQuantities();
        return ResponseEntity.ok(gtins);
    }

    // GET endpoint to retrieve the latest batch with non-positive available quantity
    @GetMapping("/batches/latest-nonpositive")
    public ResponseEntity<List<Batch>> getLatestBatchWithNonPositiveQuantity() {
        List<Batch> batches = inventoryService.getLatestBatchWithNonPositiveQuantity();
        return ResponseEntity.ok(batches);
    }
    // Get GTINs with positive available quantity batches
    @GetMapping("/gtins/positive-batches")
    public ResponseEntity<List<Gtin>> getGtinsWithPositiveBatches() {
        List<Gtin> gtins = inventoryService.getGtinsWithPositiveBatches();
        return ResponseEntity.ok(gtins);
    }
}
