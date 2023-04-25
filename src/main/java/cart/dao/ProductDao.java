package cart.dao;

import cart.controller.ProductRequest;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao implements CrudDao<ProductEntity, ProductRequest> {

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(ProductRequest request) {
        String query = "INSERT INTO product (name, price, image_url) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, request.getName(), request.getPrice(), request.getImageUrl());
    }

    @Override
    public List<ProductEntity> findAll() {
        return null;
    }

    @Override
    public ProductEntity findById(Long id) {
        return null;
    }

    @Override
    public void updateById(Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}