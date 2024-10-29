package com.techelevator.dao;

import com.techelevator.model.CartItem;

import java.util.List;

public interface CartDao {
    List<CartItem> getCartByUserId(int userId);
    void addOrUpdateCartItem(int userId, int productId, int quantity);
    void removeCartItem(int userId, int productId);
    void clearCart(int userId);
}
