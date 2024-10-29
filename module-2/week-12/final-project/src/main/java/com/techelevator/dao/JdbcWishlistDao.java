package com.techelevator.dao;

import com.techelevator.model.Wishlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWishlistDao implements WishlistDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWishlistDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Wishlist> getWishlistsByUserId(int userId) {
        String sql = "SELECT * FROM wishlist WHERE user_id = ?";
        List<Wishlist> wishlists = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setWishlistId(results.getInt("wishlist_id"));
            wishlist.setName(results.getString("name"));
            wishlist.setUserId(results.getInt("user_id"));
            wishlists.add(wishlist);
        }
        return wishlists;
    }

    @Override
    public Wishlist getWishlistById(int wishlistId) {
        String sql = "SELECT * FROM wishlist WHERE wishlist_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, wishlistId);

        if (!results.next()) {
            return null;
        }

        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistId(results.getInt("wishlist_id"));
        wishlist.setName(results.getString("name"));
        wishlist.setUserId(results.getInt("user_id"));
        return wishlist;
    }

    @Override
    public void createWishlist(Wishlist wishlist) {
        String sql = "INSERT INTO wishlist (name, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, wishlist.getName(), wishlist.getUserId());
    }

    @Override
    public void deleteWishlist(int wishlistId, int userId) {
        // Only delete the wishlist if it belongs to the authenticated user
        String sql = "DELETE FROM wishlist WHERE wishlist_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, wishlistId, userId);
    }

    @Override
    public void addProductToWishlist(int wishlistId, int productId) {
        // Check if the product is already on the wishlist
        String checkSql = "SELECT * FROM wishlist_item WHERE wishlist_id = ? AND product_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(checkSql, wishlistId, productId);

        if (!results.next()) {
            // If the product is not already on the wishlist, add it
            String insertSql = "INSERT INTO wishlist_item (wishlist_id, product_id) VALUES (?, ?)";
            jdbcTemplate.update(insertSql, wishlistId, productId);
        }
        // No error if the product is already on the wishlist; just don't add it again.
    }

    @Override
    public void removeProductFromWishlist(int wishlistId, int productId) {
        // Check if the product exists on the wishlist
        String checkSql = "SELECT * FROM wishlist_item WHERE wishlist_id = ? AND product_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(checkSql, wishlistId, productId);

        if (results.next()) {
            // If the product is on the wishlist, remove it
            String deleteSql = "DELETE FROM wishlist_item WHERE wishlist_id = ? AND product_id = ?";
            jdbcTemplate.update(deleteSql, wishlistId, productId);
        }
        // No error if the product is not on the wishlist; just do nothing.
    }
}
