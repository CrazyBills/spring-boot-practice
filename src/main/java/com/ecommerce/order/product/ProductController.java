package com.ecommerce.order.product;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductApplicationService productApplicationService;

    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ImmutableMap<String, String> createProduct(@RequestBody @Valid CreateProductCommand command) {

        Product product = Product.create(command.getName(), command.getDescription(), command.getPrice());

        return ImmutableMap.of("id", productApplicationService.createProduct(product).getId());
    }

}
