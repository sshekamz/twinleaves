package com.twinleaves.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private LocalDate createdOn;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Gtin> gtins;

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public List<Gtin> getGtins() {
        return gtins;
    }

    public void setGtins(List<Gtin> gtins) {
        this.gtins = gtins;
    }
}