package com.ecommerce.order.product;

import org.springframework.stereotype.Service;

@Service
public class ProductApplicationService {

    private final ProductRepository productRepository;

    public ProductApplicationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return null;
    }
}
