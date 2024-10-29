package com.techelevator.dao;

import com.techelevator.model.Wishlist;

import java.util.List;
public interface WishlistDao {

    List<Wishlist> getWishlistsByUserId(int userId);

    Wishlist getWishlistById(int wishlistId);
    void createWishlist(Wishlist wishlist);

    void deleteWishlist(int wishlistId, int userId);

    void addProductToWishlist(int wishlistId, int productId);

    void removeProductFromWishlist(int wishlistId, int productId);
}
