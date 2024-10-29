package com.techelevator.controller;

import com.techelevator.dao.JdbcProductDao;
import com.techelevator.dao.ProductDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;

    // Inject the ProductDao via the constructor
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    // 1. View all products or search products by SKU or name
    @GetMapping
    public List<Product> getAll(@RequestParam(required = false) String sku,
                                @RequestParam(required = false) String name) {
        try {
            // If no search terms are provided, return all products
            if (sku == null && name == null) {
                return productDao.getAllProducts();
            } else {
                // If either sku or name is provided, search for products
                return productDao.findProductByNameOrSku(sku, name);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "DAO Error - " + e.getMessage());
        }
    }

    // 2. View additional details of a specific product by ID
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        try {
            Product product = productDao.getProductById(productId);
            if (product == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
            }
            return product;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "DAO Error - " + e.getMessage());
        }
    }
}
