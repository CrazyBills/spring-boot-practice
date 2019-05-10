package com.ecommerce.order.product;

import com.ecommerce.order.common.utils.PagedResource;
import com.ecommerce.order.product.representation.ProductSummaryRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductApplicationService productApplicationService;

    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public String createProduct(@RequestBody @Valid CreateProductCommand command) {


        Product product = Product.create(command.getName(), command.getDescription(), command.getPrice());

        return productApplicationService.createProduct(product).getId();
    }

    @GetMapping
    public PagedResource<ProductSummaryRepresentation> pagedProducts(@RequestParam(required = false, defaultValue = "1") int pageIndex,
                                                                     @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return productApplicationService.listProduct(pageIndex, pageSize)
                .map(it -> new ProductSummaryRepresentation(it.getId().toString(), it.getName(), it.getPrice()));
    }


    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public Product byId(@PathVariable(name = "id") String id) {
        return productApplicationService.getById(id);
    }

}
