package com.techelevator.dao;
import com.techelevator.model.CartItem;
import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCartDao implements CartDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCartDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CartItem> getCartByUserId(int userId) {
        String sql = "SELECT p.product_id, p.name, p.price, c.quantity FROM cart_item c " +
                "JOIN product p ON c.product_id = p.product_id WHERE c.user_id = ?";
        List<CartItem> cartItems = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            CartItem item = new CartItem();
            item.setProductId(results.getInt("product_id"));
            item.setProductName(results.getString("name"));
            item.setProductPrice(results.getDouble("price"));
            item.setQuantity(results.getInt("quantity"));
            cartItems.add(item);
        }
        return cartItems;
    }

    @Override
    public void addOrUpdateCartItem(int userId, int productId, int quantity) {
        String checkSql = "SELECT * FROM cart_item WHERE user_id = ? AND product_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(checkSql, userId, productId);
        if (result.next()) {
            int currentQuantity = result.getInt("quantity");
            String updateSql = "UPDATE cart_item SET quantity = ? WHERE user_id = ? AND product_id = ?";
            jdbcTemplate.update(updateSql, currentQuantity + quantity, userId, productId);
        } else {
            String insertSql = "INSERT INTO cart_item (user_id, product_id, quantity) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertSql, userId, productId, quantity);
        }
    }

    @Override
    public void removeCartItem(int userId, int productId) {
        String deleteSql = "DELETE FROM cart_item WHERE user_id = ? OR product_id = ?";
        jdbcTemplate.update(deleteSql, userId, productId);
    }

    @Override
    public void clearCart(int userId) {
        String deleteAllSql = "DELETE FROM cart_item WHERE user_id = ?";
        jdbcTemplate.update(deleteAllSql, userId);
    }

}
