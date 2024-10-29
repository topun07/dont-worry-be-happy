package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Product;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY product_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToProduct(results));
        }
        return products;
    }

    @Override
    public List<Product> searchProducts(String searchTerm) {
        return null;
    }

    /*
    @Override
    public List<Product> findProductByNameOrSku(String sku, String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE LOWER(product_sku) LIKE ? OR LOWER(name) LIKE ?";
        String skuSearch = "%" + ((sku != null) ? sku.toLowerCase() : "") + "%";
        String nameSearch = "%" + ((name != null) ? name.toLowerCase() : "") + "%";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, skuSearch, nameSearch);
        while (results.next()) {
            products.add(mapRowToProduct(results));
        }
        return products;
    } */

    @Override
    public List<Product> findProductByNameOrSku(String sku, String name) {
        List<Product> products = new ArrayList<>();
        String sql;

        if (sku != null && !sku.isEmpty()) {
            // Exact match on SKU
            sql = "SELECT * FROM product WHERE LOWER(product_sku) = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, sku.toLowerCase());
            while (results.next()) {
                products.add(mapRowToProduct(results));
            }
        } else if (name != null && !name.isEmpty()) {
            // Partial match on name
            sql = "SELECT * FROM product WHERE LOWER(name) LIKE ?";
            String nameSearch = "%" + name.toLowerCase() + "%";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, nameSearch);
            while (results.next()) {
                products.add(mapRowToProduct(results));
            }
        }
        return products;
    }


    @Override
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM product WHERE product_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, productId);
        if (result.next()) {
            return mapRowToProduct(result);
        } else {
            throw new DaoException("Product not found");
        }
    }

    @Override
    public Product getProductBySku(String sku) {
        return null;
    }

    // Mapping helper method
    private Product mapRowToProduct(SqlRowSet rs) {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductSku(rs.getString("product_sku"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setImageName(rs.getString("image_name"));
        return product;
    }
}
