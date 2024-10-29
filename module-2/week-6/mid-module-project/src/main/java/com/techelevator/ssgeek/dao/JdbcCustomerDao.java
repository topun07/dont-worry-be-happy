package com.techelevator.ssgeek.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.ssgeek.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.ssgeek.exception.DaoException;

public class JdbcCustomerDao implements CustomerDao{

        private final JdbcTemplate jdbcTemplate;

        public JdbcCustomerDao(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

        @Override
        public Customer getCustomerById(int customerId) {
            Customer customer = null;
            String sql = "SELECT customer_id, name, street_address1, street_address2, city, state, zip_code " +
                    "FROM customer " +
                    "WHERE customer_id = ?";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
                if (results.next()) {
                    customer = mapRowToCustomer(results);
                }
            }
            catch (CannotGetJdbcConnectionException e){
                throw new DaoException("Unable to connect to server or database", e);
            }
            return customer;
        }

        @Override
        public List<Customer> getCustomers() {
            List<Customer> customers = new ArrayList<>();
            String sql = "SELECT customer_id, name, street_address1, street_address2, city, state, zip_code FROM customer";

            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
                while (results.next()) {
                    Customer customer = mapRowToCustomer(results);
                    customers.add(customer);
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            }

            return customers;
        }

        @Override
        public Customer createCustomer(Customer newCustomer) {
            String sql = "INSERT INTO Customer (name, street_address1, street_address2, city, state, zip_code) " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING customer_id, name, street_address1, street_address2, city, state, zip_code";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,
                    //newCustomer.getCustomerId(),
                    newCustomer.getName(),
                    newCustomer.getStreetAddress1(),
                    newCustomer.getStreetAddress2(),
                    newCustomer.getCity(),
                    newCustomer.getState(),
                    newCustomer.getZipCode()
            );

            if (results.next()) {
                return mapRowToCustomer(results);
            } else {
                throw new RuntimeException("Error: Could not retrieve the new customer information after insert.");
            }
        }

        @Override
        public Customer updateCustomer(Customer updatedCustomer) {
            String sql = "UPDATE customer SET name = ?, street_address1 = ?, street_address2 = ?, city = ?, state = ?, zip_code = ? " +
                    "WHERE customer_id = ?";

            try {
                int rowsAffected = jdbcTemplate.update(sql,
                        updatedCustomer.getName(),
                        updatedCustomer.getStreetAddress1(),
                        updatedCustomer.getStreetAddress2(),
                        updatedCustomer.getCity(),
                        updatedCustomer.getState(),
                        updatedCustomer.getZipCode(),
                        updatedCustomer.getCustomerId()
                );

                if (rowsAffected == 0) {
                    throw new DaoException("Error: No customer found with ID " + updatedCustomer.getCustomerId());
                }

                return getCustomerById(updatedCustomer.getCustomerId());
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Error updating customer with ID " + updatedCustomer.getCustomerId(), e);
            }
        }

        private Customer mapRowToCustomer(SqlRowSet results) {
            Customer customer = new Customer();
            customer.setCustomerId(results.getInt("customer_id"));
            customer.setName(results.getString("name"));
            customer.setStreetAddress1(results.getString("street_address1"));
            customer.setStreetAddress2(results.getString("street_address2"));
            customer.setCity(results.getString("city"));
            customer.setState(results.getString("state"));
            customer.setZipCode(results.getString("zip_code"));
            return customer;
        }

    }
