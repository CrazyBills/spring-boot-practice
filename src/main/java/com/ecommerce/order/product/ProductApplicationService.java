package com.ecommerce.order.product;

import com.ecommerce.order.common.utils.PagedResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductApplicationService {

    private final ProductRepository productRepository;

    public ProductApplicationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public PagedResource<Product> listProduct(int pageIndex, int pageSize) {

        List<Product> products = productRepository.listProduct(pageIndex, pageSize);
        Integer count = productRepository.count();

        return PagedResource.of(count, pageIndex, products);
    }

    public Product getById(String id) {
        return productRepository.byId(ProductId.productId(id));
    }
}
