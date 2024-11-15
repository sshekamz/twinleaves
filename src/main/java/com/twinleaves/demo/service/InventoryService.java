package com.twinleaves.demo.service;

import com.twinleaves.demo.entity.Batch;
import com.twinleaves.demo.entity.Gtin;
import com.twinleaves.demo.entity.Product;
import com.twinleaves.demo.repository.BatchRepository;
import com.twinleaves.demo.repository.GtinRepository;
import com.twinleaves.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private GtinRepository gtinRepository;

    // Method to create a new Product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Method to create a new GTIN
    public Gtin createGtin(Gtin gtin) {
        return gtinRepository.save(gtin);
    }

    // Method to create a new Batch
    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    // Method to get GTINs with batches having positive quantities
    public List<Gtin> getGtinsWithPositiveQuantities() {
        return gtinRepository.findAllGtinsWithPositiveBatchQuantities();
    }

    // Method to get the latest batch with non-positive quantity
    public List<Batch> getLatestBatchWithNonPositiveQuantity() {
        return batchRepository.findLatestBatchWithNonPositiveQuantity();
    }
    //method to get gtin with positive branches
    public List<Gtin> getGtinsWithPositiveBatches() {
        return gtinRepository.findAllGtinsWithPositiveBatchQuantities();
    }
}
