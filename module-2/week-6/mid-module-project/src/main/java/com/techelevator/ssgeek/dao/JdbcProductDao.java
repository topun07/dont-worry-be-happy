package com.techelevator.ssgeek.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.ssgeek.model.Product;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.ssgeek.exception.DaoException;
public class JdbcProductDao implements ProductDao{

private final JdbcTemplate jdbcTemplate;

public JdbcProductDao(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        String sql = "SELECT product_id, name, description, price, image_name " +
                "FROM product " + "WHERE product_id = ? ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
            if (results.next()) {
                product = mapRowToProduct(results);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return product;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, name, description, price, image_name FROM product";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return products;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.product_id, p.name, p.description, p.price, p.image_name " +
                "FROM product p " +
                "LEFT JOIN line_item l ON p.product_id = l.product_id " +
                "WHERE l.product_id IS NULL order by p.product_id; ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return products;
    }

    @Override
    public Product createProduct(Product newProduct) {
        String sql = "INSERT INTO product (name, description, price, image_name) " +
                "VALUES (?, ?, ?, ?) RETURNING product_id";
        try {
            Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                    newProduct.getName(), newProduct.getDescription(), newProduct.getPrice(), newProduct.getImageName());
            return getProductById(newId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error inserting new product", e);
        }
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        String sql = "UPDATE product SET name = ?, description = ?, price = ?, image_name = ? " +
                "WHERE product_id = ?";
        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    updatedProduct.getName(), updatedProduct.getDescription(),
                    updatedProduct.getPrice(), updatedProduct.getImageName(),
                    updatedProduct.getProductId());

            if (rowsAffected == 0) {
                throw new DaoException("Error: No product found with ID " + updatedProduct.getProductId());
            }
            return getProductById(updatedProduct.getProductId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error updating product with ID " + updatedProduct.getProductId(), e);
        }
    }

    @Override
    public int deleteProductById(int productId) {
        String sql = "DELETE FROM product WHERE product_id = ?";
        try {
            return jdbcTemplate.update(sql, productId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error deleting product with ID " + productId, e);
        }
    }

    private Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();
        product.setProductId(results.getInt("product_id"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImageName(results.getString("image_name"));
        return product;
    }
}
