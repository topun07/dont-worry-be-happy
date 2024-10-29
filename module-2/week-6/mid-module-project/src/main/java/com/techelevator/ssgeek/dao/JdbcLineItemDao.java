package com.techelevator.ssgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.ssgeek.model.LineItem;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.ssgeek.exception.DaoException;
import org.springframework.transaction.annotation.Transactional;

public class JdbcLineItemDao implements LineItemDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcLineItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<LineItem> getLineItemsBySaleId(int saleId) {
        List<LineItem> lineItems = new ArrayList<>();
        String sql = "SELECT l.line_item_id, l.sale_id, l.product_id, l.quantity, p.name, p.price FROM line_item l " +
               "join product p ON p.product_id = l.product_id  where l.sale_id = ? order by l.line_item_id" ;

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
            while (results.next()) {
                LineItem lineItem = mapRowToLineItem(results);
                lineItems.add(lineItem);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return lineItems;
    }

    private LineItem mapRowToLineItem(SqlRowSet results) {
        LineItem lineItem = new LineItem();
        lineItem.setLineItemId(results.getInt("line_item_id"));
        lineItem.setSaleId(results.getInt("sale_id"));
        lineItem.setProductId(results.getInt("product_id"));
        lineItem.setQuantity(results.getInt("quantity"));
        lineItem.setPrice(results.getBigDecimal("price"));
        lineItem.setProductName(results.getString("name"));
        return  lineItem;
    }
}
