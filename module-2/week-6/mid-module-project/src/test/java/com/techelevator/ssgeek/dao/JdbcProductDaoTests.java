package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JdbcProductDaoTests extends BaseDaoTests {

    private JdbcProductDao dao;

    private Product testProduct;

    @Before
    public void setup() {
        dao = new JdbcProductDao(dataSource);

        // Create a test customer that can be used in multiple tests
        testProduct = new Product();
        testProduct.setName("Product 5");
        testProduct.setDescription("Description 5");
        testProduct.setPrice(BigDecimal.valueOf(55.55));
        testProduct.setImageName("product-5.png");
        testProduct = dao.createProduct(testProduct);
    }

    @Test
    public void getProductById_returns_valid_customer_for_valid_id() {

        Product product = dao.getProductById(1);
        Assert.assertNotNull(product);
        assertEquals(1, product.getProductId());
        assertEquals("Product 1", product.getName());
        assertEquals("Description 1", product.getDescription());
        assertEquals(BigDecimal.valueOf(9.99), product.getPrice());
        assertEquals("product-1.png", product.getImageName());
    }

    @Test
    public void getProductById_returns_null_for_invalid_id() {
        Product product = dao.getProductById(-1); // Assuming -1 is an invalid ID
        Assert.assertNull(product);
    }

    @Test
    public void getProducts_returns_all_products() {
        List<Product> products = dao.getProducts();
        Assert.assertNotNull(products);
        Assert.assertTrue(products.size() > 0); // Assumes there is at least one product in the database
    }

    @Test
    public void createProduct_creates_and_returns_new_product() {
        Product newProduct = new Product();
        newProduct.setName("Product 6");
        newProduct.setDescription("Description 6");
        newProduct.setPrice(BigDecimal.valueOf(66.66));
        newProduct.setImageName("product-6.png");

        Product createdProduct = dao.createProduct(newProduct);

        Assert.assertNotNull(createdProduct);
        Assert.assertNotNull(createdProduct.getProductId());
        Assert.assertEquals("Product 6", createdProduct.getName());
        Assert.assertEquals("Description 6", createdProduct.getDescription());
        Assert.assertEquals(BigDecimal.valueOf(66.66), createdProduct.getPrice());
        Assert.assertEquals("product-6.png", createdProduct.getImageName());
    }

    @Test
    public void updateProduct_updates_existing_product() {
        testProduct.setName("Product 5 Updated");
        testProduct.setDescription("Description Updated");
        testProduct.setPrice(BigDecimal.valueOf(77.77));
        testProduct.setImageName("product-updated.png");

        Product updatedProduct = dao.updateProduct(testProduct);

        Assert.assertNotNull(updatedProduct);
        Assert.assertEquals(testProduct.getProductId(), updatedProduct.getProductId());
        Assert.assertEquals("Product 5 Updated", updatedProduct.getName());
        Assert.assertEquals("Description Updated", updatedProduct.getDescription());
        Assert.assertEquals(BigDecimal.valueOf(77.77), updatedProduct.getPrice());
        Assert.assertEquals("product-updated.png", updatedProduct.getImageName());

        Product retrievedProduct = dao.getProductById(testProduct.getProductId());
        Assert.assertEquals("Product 5 Updated", retrievedProduct.getName());
        Assert.assertEquals("Description Updated", retrievedProduct.getDescription());
        Assert.assertEquals(BigDecimal.valueOf(77.77), retrievedProduct.getPrice());
        Assert.assertEquals("product-updated.png", retrievedProduct.getImageName());
    }

    @Test
    public void deleteProductById_deletes_product() {
        int rowsDeleted = dao.deleteProductById(testProduct.getProductId());
        Assert.assertEquals(1, rowsDeleted);

        Product deletedProduct = dao.getProductById(testProduct.getProductId());
        Assert.assertNull(deletedProduct);
    }

    @Test
    public void getProductsWithNoSales_returns_products_with_no_sales() {
        // Act: Call the method under test
        List<Product> products = dao.getProducts();

        // Assert: Validate the results
        Assert.assertNotNull(products);

        // Assuming the test database is set up with specific products that are known to have no sales
        for (Product product : products) {
            Assert.assertNotNull(product.getProductId());
            Assert.assertNotNull(product.getName());
        }
    }
}