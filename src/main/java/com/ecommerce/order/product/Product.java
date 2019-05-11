package com.ecommerce.order.product;

import com.ecommerce.order.common.utils.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;

public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Instant createdAt;

    private Product() {
    }

    public Product(String id, String name, String description, BigDecimal price, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    private Product(String name, String description, BigDecimal price) {
        this.id = UuidGenerator.newUuid();
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = Instant.now();
    }

    public static Product create(String name, String description, BigDecimal price) {
        return new Product(name, description, price);
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
