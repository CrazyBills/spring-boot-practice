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
