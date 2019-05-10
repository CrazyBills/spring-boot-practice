package com.ecommerce.order.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(ProductId id) {
        super(id.toString());
    }
}
