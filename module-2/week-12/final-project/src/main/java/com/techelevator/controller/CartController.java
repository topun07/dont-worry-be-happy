package com.techelevator.controller;

import com.techelevator.dao.CartDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;  // Assuming this exists to get user details by username

    // GET /cart - View cart details
    @GetMapping
    public CartDTO viewCart(Authentication authentication) {
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Fetch cart items for the authenticated user
        List<CartItem> cartItems = cartDao.getCartByUserId(user.getId());

        // Calculate the subtotal
        double subtotal = cartItems.stream()
                .mapToDouble(item -> item.getProductPrice() * item.getQuantity())
                .sum();

        // Obtain the tax rate from an external API
        double taxRate = getTaxRateForState(user.getStateCode());

        // Calculate the tax amount
        double taxAmount = subtotal * taxRate;

        // Calculate the total (subtotal + tax)
        double total = subtotal + taxAmount;

        // Map CartItem to CartItemDTO
        List<CartItemDTO> cartItemDTOs = cartItems.stream().map(item -> {
            CartItemDTO dto = new CartItemDTO();
            dto.setProductId(item.getProductId());
            dto.setProductName(item.getProductName());
            dto.setProductPrice(item.getProductPrice());
            dto.setQuantity(item.getQuantity());
            return dto;
        }).collect(Collectors.toList());

        // Return CartDTO with cart details
        CartDTO cartDTO = new CartDTO();
        cartDTO.setItems(cartItemDTOs);
        cartDTO.setSubtotal(subtotal);
        cartDTO.setTaxAmount(taxAmount);
        cartDTO.setTotal(total);

        return cartDTO;
    }

    // POST /cart/items - Add an item to the cart
    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public void addToCart(@RequestParam int productId, @RequestParam int quantity, Authentication authentication) {
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Validate quantity
        if (quantity <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity must be positive");
        }

        // Add or update the product in the cart
        cartDao.addOrUpdateCartItem(user.getId(), productId, quantity);
    }

    // DELETE /cart/items/{itemId} - Remove an item from the cart
    @DeleteMapping("/items/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFromCart(@PathVariable int productId, Authentication authentication) {
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Remove the product from the cart
        cartDao.removeCartItem(user.getId(), productId);
    }

    // DELETE /cart - Clear the cart
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart(Authentication authentication) {
        String username = authentication.getName();
        User user = userDao.getUserByUsername(username);

        cartDao.clearCart(user.getId());
    }

    // Helper method to get the tax rate from an external API
    private double getTaxRateForState(String stateCode) {
        String apiUrl = "https://teapi.netlify.app/api/statetax?state=" + stateCode;
        RestTemplate restTemplate = new RestTemplate();

        try {
            TaxRateResponse response = restTemplate.getForObject(apiUrl, TaxRateResponse.class);
            if (response != null) {
                return response.getRate() / 100.0; // Convert percentage to decimal
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid response from tax rate API");
            }
        } catch (Exception e) {
            // Add more detailed logging for troubleshooting
            System.err.println("Error occurred while fetching tax rate: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error calling tax rate API", e);
        }
    }

}
