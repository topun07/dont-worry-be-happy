package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcCustomerDaoTests extends BaseDaoTests{
    private JdbcCustomerDao dao;

    private Customer testCustomer;

    @Before
    public void setup(){
        dao = new JdbcCustomerDao(dataSource);

        // Create a test customer that can be used in multiple tests
        testCustomer = new Customer();
        testCustomer.setName("Jane Doe");
        testCustomer.setStreetAddress1("456 Elm St");
        testCustomer.setStreetAddress2("Unit 5");
        testCustomer.setCity("Smalltown");
        testCustomer.setState("TX");
        testCustomer.setZipCode("67890");
        testCustomer = dao.createCustomer(testCustomer);
    }

    @Test
    public void getCustomerById_returns_valid_customer_for_valid_id(){
        Customer c = dao.getCustomerById(1);
        Assert.assertNotNull(c);
        Assert.assertEquals("Customer 1", c.getName());
    }

    @Test
    public void getCustomerById_returns_null_for_invalid_id(){
        Customer c = dao.getCustomerById(5);
        Assert.assertNull(c);
    }

    @Test
    public void getCustomer() {
        List<Customer> customer = dao.getCustomers();
        Assert.assertEquals(customer.size(), 5);
    }

    @Test
    public void createCustomer_creates_and_returns_new_customer() {
        // Arrange
        Customer newCustomer = new Customer();
        newCustomer.setName("John Doe");
        newCustomer.setStreetAddress1("Addr 5-1");
        newCustomer.setStreetAddress2("Addr 5-2");
        newCustomer.setCity("City 5");
        newCustomer.setState("S5");
        newCustomer.setZipCode("55555");

        // Act
        Customer createdCustomer = dao.createCustomer(newCustomer);

        // Assert
        Assert.assertNotNull(createdCustomer);
        Assert.assertNotNull(createdCustomer.getCustomerId());
        Assert.assertEquals("John Doe", createdCustomer.getName());
        Assert.assertEquals("Addr 5-1", createdCustomer.getStreetAddress1());
        Assert.assertEquals("Addr 5-2", createdCustomer.getStreetAddress2());
        Assert.assertEquals("City 5", createdCustomer.getCity());
        Assert.assertEquals("S5", createdCustomer.getState());
        Assert.assertEquals("55555", createdCustomer.getZipCode());

        // Optionally, verify that the customer was added to the database
        Customer retrievedCustomer = dao.getCustomerById(createdCustomer.getCustomerId());
        Assert.assertNotNull(retrievedCustomer);
    }

    @Test
    public void updateCustomer_updates_existing_customer() {
        testCustomer.setName("Jane Doe Updated");
        testCustomer.setCity("New City");
        Customer updatedCustomer = dao.updateCustomer(testCustomer);

        Assert.assertNotNull(updatedCustomer);
        Assert.assertEquals(testCustomer.getCustomerId(), updatedCustomer.getCustomerId());
        Assert.assertEquals("Jane Doe Updated", updatedCustomer.getName());
        Assert.assertEquals("New City", updatedCustomer.getCity());

        Customer retrievedCustomer = dao.getCustomerById(testCustomer.getCustomerId());
        Assert.assertEquals("Jane Doe Updated", retrievedCustomer.getName());
        Assert.assertEquals("New City", retrievedCustomer.getCity());
    }

}
