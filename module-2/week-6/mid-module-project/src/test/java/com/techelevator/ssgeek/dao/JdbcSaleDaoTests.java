package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class JdbcSaleDaoTests extends BaseDaoTests{

    private JdbcSaleDao dao;

    private Sale testSale;

        @Before
        public void setup() {
            dao = new JdbcSaleDao(dataSource);

            // Create a test sale that can be used in multiple tests
            testSale = new Sale();
            testSale.setCustomerId(1);  // Assuming customer with ID 1 exists
            testSale.setSaleDate(LocalDate.now());
            testSale.setShipDate(null);  // Unshipped sale
            testSale = dao.createSale(testSale);
        }

        @Test
        public void getSaleById_returns_valid_sale_for_valid_id() {
            Sale s = dao.getSaleById(1);
            Assert.assertNotNull(s);
            Assert.assertEquals(1, s.getSaleId());
            Assert.assertEquals(1, s.getCustomerId());
            Assert.assertEquals(LocalDate.of(2022, 1, 1), s.getSaleDate());
            Assert.assertEquals(null, s.getShipDate());
        }

        @Test
        public void getSaleById_returns_null_for_invalid_id() {
            Sale s = dao.getSaleById(-1);  // Assuming -1 is an invalid ID
            Assert.assertNull(s);
        }

        @Test
        public void getUnshippedSales_returns_sales_with_no_ship_date() {
            List<Sale> unshippedSales = dao.getUnshippedSales();
            Assert.assertNotNull(unshippedSales);
            Assert.assertFalse(unshippedSales.isEmpty());

            for (Sale sale : unshippedSales) {
                Assert.assertNull(sale.getShipDate());
            }
        }

        @Test
        public void getSalesByCustomerId_returns_sales_for_customer() {
            List<Sale> sales = dao.getSalesByCustomerId(testSale.getCustomerId());
            Assert.assertNotNull(sales);
            Assert.assertFalse(sales.isEmpty());

            for (Sale sale : sales) {
                Assert.assertEquals(testSale.getCustomerId(), sale.getCustomerId());
            }
        }

        @Test
        public void getSalesByProductId_returns_sales_for_product() {
            // This test assumes that the test database is pre-populated with sales that have line items
            int testProductId = 1;  // Assuming product with ID 1 exists and has sales
            List<Sale> productSales = dao.getSalesByProductId(testProductId);
            Assert.assertNotNull(productSales);
            Assert.assertFalse(productSales.isEmpty());

            // You may add additional assertions if your database setup allows it
        }

        @Test
        public void createSale_creates_and_returns_new_sale() {
            Sale newSale = new Sale();
            newSale.setCustomerId(2);  // Assuming customer with ID 2 exists
            newSale.setSaleDate(LocalDate.now());
            newSale.setShipDate(null);

            Sale createdSale = dao.createSale(newSale);

            Assert.assertNotNull(createdSale);
            Assert.assertNotNull(createdSale.getSaleId());
            Assert.assertEquals(newSale.getCustomerId(), createdSale.getCustomerId());
            Assert.assertEquals(newSale.getSaleDate(), createdSale.getSaleDate());
            Assert.assertEquals(newSale.getShipDate(), createdSale.getShipDate());
        }

        @Test
        public void updateSale_updates_existing_sale() {
            testSale.setShipDate(LocalDate.now().plusDays(1));  // Ship date is tomorrow

            Sale updatedSale = dao.updateSale(testSale);

            Assert.assertNotNull(updatedSale);
            Assert.assertEquals(testSale.getSaleId(), updatedSale.getSaleId());
            Assert.assertEquals(testSale.getCustomerId(), updatedSale.getCustomerId());
            Assert.assertEquals(testSale.getSaleDate(), updatedSale.getSaleDate());
            Assert.assertEquals(testSale.getShipDate(), updatedSale.getShipDate());

            Sale retrievedSale = dao.getSaleById(testSale.getSaleId());
            Assert.assertEquals(testSale.getShipDate(), retrievedSale.getShipDate());
        }

        @Test
        public void deleteSaleById_deletes_sale() {
            int rowsDeleted = dao.deleteSaleById(testSale.getSaleId());
            Assert.assertEquals(1, rowsDeleted);

            Sale deletedSale = dao.getSaleById(testSale.getSaleId());
            Assert.assertNull(deletedSale);
        }
    }

