package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao { // revised
    List<Product> getAllProducts();
    List<Product> searchProducts(String searchTerm);
    Product getProductById(int productId);
    Product getProductBySku(String sku);
    List<Product> findProductByNameOrSku(String sku, String name);
}
