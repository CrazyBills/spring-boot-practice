package com.ecommerce.order.product;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Component
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Product product) {
        String sql = "INSERT INTO PRODUCT (ID, NAME, PRICE, DESCRIPTION, CREATED_AT)" +
                " VALUES (:id, :name, :price, :description, :created_at) ";
        Map<String, String> paramMap = of("id", product.getId(),
                "name", product.getName(),
                "description", product.getDescription(),
                "price", product.getPrice().toString(),
                "created_at", Long.toString(product.getCreatedAt().toEpochMilli()));
        jdbcTemplate.update(sql, paramMap);
    }

    public Product byId(ProductId id) {
        try {
            String sql = "SELECT * FROM PRODUCT WHERE ID=:id;";
            return jdbcTemplate.queryForObject(sql, of("id", id.toString()), mapper());
        } catch (EmptyResultDataAccessException e) {
            throw new ProductNotFoundException(id);
        }
    }


    private RowMapper<Product> mapper() {
        return (rs, rowNum) -> {
            String id = rs.getString("ID");
            String name = rs.getString("NAME");
            String description = rs.getString("DESCRIPTION");
            BigDecimal price = rs.getBigDecimal("PRICE");
            Instant createdAt = Instant.ofEpochMilli(rs.getLong("CREATED_AT"));
            return new Product(id, name, description, price, createdAt);
        };
    }

    public List<Product> listProduct(int pageIndex, int pageSize) {
        String sql = "SELECT * FROM PRODUCT LIMIT :pageIndex,:pageSize;";

        return jdbcTemplate.query(sql, of("pageIndex", pageIndex, "pageSize", pageSize), mapper());
    }

    public Integer count() {

        String sql = "SELECT COUNT(*) FROM PRODUCT;";
        return jdbcTemplate.queryForObject(sql, of(), Integer.class);
    }
}
