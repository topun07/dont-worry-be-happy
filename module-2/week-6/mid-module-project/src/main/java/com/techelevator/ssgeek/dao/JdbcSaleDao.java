package com.techelevator.ssgeek.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.ssgeek.exception.DaoException;

public class JdbcSaleDao implements SaleDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSaleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Sale getSaleById(int saleId) {
        Sale sale = null;

        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, c.name " +
        "FROM sale s " +
        "join customer c ON  c.customer_id = s.customer_id " +
        "WHERE s.sale_id = ? ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
            if (results.next()) {
                sale = mapRowToSale(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return sale;
    }

    @Override
    public List<Sale> getUnshippedSales() {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, c.name FROM sale s JOIN customer c ON c.customer_id = s.customer_id WHERE s.ship_date IS NULL order by sale_id ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Sale sale = mapRowToSale(results);
                sales.add(sale);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return sales;
    }

    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, p.product_id, p.name \n" +
                "FROM sale s \n" +
                "JOIN line_item l ON s.sale_id = l.sale_id \n" +
                "JOIN product p ON l.product_id = p.product_id \n" +
                "WHERE s.customer_id = ? \n" +
                "ORDER BY s.sale_id asc, p.product_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
            while (results.next()) {
                Sale sale = mapRowToSale(results);
                sales.add(sale);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return sales;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, c.name " +
                "FROM sale s " +
                "JOIN line_item l ON s.sale_id = l.sale_id Join customer c ON s.customer_id = c.customer_id " +
                "WHERE l.product_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
            while (results.next()) {
                Sale sale = mapRowToSale(results);
                sales.add(sale);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return sales;
    }

    @Override
    public Sale createSale(Sale newSale) {
        String sql = "INSERT INTO sale (customer_id, sale_date, ship_date) " +
                "VALUES (?, ?, ?) RETURNING sale_id";
        try {
            Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                    newSale.getCustomerId(), newSale.getSaleDate(), newSale.getShipDate());
            return getSaleById(newId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error inserting new sale", e);
        }
    }

    @Override
    public Sale updateSale(Sale updatedSale) {
        String sql = "UPDATE sale SET customer_id = ?, sale_date = ?, ship_date = ? WHERE sale_id = ?";
        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    updatedSale.getCustomerId(), updatedSale.getSaleDate(),
                    updatedSale.getShipDate(), updatedSale.getSaleId());

            if (rowsAffected == 0) {
                throw new DaoException("Error: No sale found with ID " + updatedSale.getSaleId());
            }
            return getSaleById(updatedSale.getSaleId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error updating sale with ID " + updatedSale.getSaleId(), e);
        }
    }

    @Override
    public int deleteSaleById(int saleId) {
        String sql = "DELETE FROM sale WHERE sale_id = ?";
        try {
            return jdbcTemplate.update(sql, saleId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error deleting sale with ID " + saleId, e);
        }
    }

    private Sale mapRowToSale(SqlRowSet results) {
        Sale sale = new Sale();
        sale.setSaleId(results.getInt("sale_id"));
        sale.setCustomerId(results.getInt("customer_id"));
        sale.setSaleDate(results.getDate("sale_date").toLocalDate());
        sale.setShipDate(results.getDate("ship_date") != null ? results.getDate("ship_date").toLocalDate() : null);
        sale.setCustomerName(results.getString("name"));
        return sale;
    }

}
