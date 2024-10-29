package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.WishlistDao;
import com.techelevator.model.User;
import com.techelevator.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishlistController {

    @Autowired
    private WishlistDao wishlistDao;

    @Autowired
    private UserDao userDao;

    @GetMapping
    public List<Wishlist> getWishlists(Authentication authentication) {
        // Get the authenticated user's username
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Retrieve the user's wishlists
        return wishlistDao.getWishlistsByUserId(user.getId());
    }

    // Get a specific wishlist by ID, including its items
    @GetMapping("/{wishlistId}")
    public Wishlist getWishlist(@PathVariable int wishlistId, Authentication authentication) {
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        Wishlist wishlist = wishlistDao.getWishlistById(wishlistId);

        if (wishlist == null || wishlist.getUserId() != user.getId()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wishlist not found");
        }

        return wishlist;
    }

    // DTO for creating a new wishlist
    public static class CreateWishlistRequest {
        private String name;

        // Getter and Setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Endpoint to create a new wishlist
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWishlist(@RequestBody CreateWishlistRequest request, Authentication authentication) {
        // Get the authenticated user's username and retrieve user details
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        if (request.getName() == null || request.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wishlist name cannot be empty");
        }

        // Create the new wishlist for the authenticated user
        Wishlist wishlist = new Wishlist();
        wishlist.setName(request.getName());
        wishlist.setUserId(user.getId());

        wishlistDao.createWishlist(wishlist);
    }

    // Endpoint to delete a wishlist
    @DeleteMapping("/delete/{wishlistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWishlist(@PathVariable int wishlistId, Authentication authentication) {
        // Get the authenticated user's username and retrieve user details
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Get the wishlist and check ownership
        Wishlist wishlist = wishlistDao.getWishlistById(wishlistId);

        if (wishlist == null || wishlist.getUserId() != user.getId()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wishlist not found or does not belong to you");
        }

        // Delete the wishlist
        wishlistDao.deleteWishlist(wishlistId, user.getId());
    }

    // DTO for adding a product to the wishlist
    public static class AddProductToWishlistRequest {
        private int productId;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }
    }

    // Endpoint to add a product to a wishlist
    @PostMapping("/{wishlistId}/add")
    @ResponseStatus(HttpStatus.OK)
    public void addProductToWishlist(@PathVariable int wishlistId, @RequestBody AddProductToWishlistRequest request, Authentication authentication) {
        // Get the authenticated user's username and retrieve user details
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Check if the wishlist belongs to the authenticated user
        Wishlist wishlist = wishlistDao.getWishlistById(wishlistId);
        if (wishlist == null || wishlist.getUserId() != user.getId()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wishlist not found or does not belong to you");
        }

        // Add the product to the wishlist (if it's not already present)
        wishlistDao.addProductToWishlist(wishlistId, request.getProductId());
    }

    // Endpoint to remove a product from a wishlist
    @DeleteMapping("/{wishlistId}/remove/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProductFromWishlist(@PathVariable int wishlistId, @PathVariable int productId, Authentication authentication) {
        // Get the authenticated user's username and retrieve user details
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Check if the wishlist belongs to the authenticated user
        Wishlist wishlist = wishlistDao.getWishlistById(wishlistId);
        if (wishlist == null || wishlist.getUserId() != user.getId()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wishlist not found or does not belong to you");
        }

        // Remove the product from the wishlist (if it exists)
        wishlistDao.removeProductFromWishlist(wishlistId, productId);
    }
}
