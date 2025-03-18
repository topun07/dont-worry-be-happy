import { createStore as _createStore } from "vuex";
import axios from "axios";

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || "",
      user: currentUser || {},
      cart: [], // ✅ Ensure this exists
      message: "", // ✅ Added message state
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem("token", token);
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      },

      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem("user", JSON.stringify(user));
      },

      LOGOUT(state) {
        localStorage.removeItem("token");
        localStorage.removeItem("user");
        state.token = "";
        state.user = {};
        state.cart = []; // ✅ Clear cart on logout
        axios.defaults.headers.common = {};
      },

      CLEAR_MESSAGE(state) {
        // ✅ Add this mutation
        state.message = "";
      },

      // ✅ Add product to cart
      ADD_TO_CART(state, product) {
        const existingProduct = state.cart.find(
          (item) => item.productId === product.productId
        );

        if (existingProduct) {
          existingProduct.quantity += 1;
        } else {
          state.cart.push({ ...product, quantity: 1 });
        }

        // Set the message
        state.message = `${product.name} added to cart!`;

        localStorage.setItem("cart", JSON.stringify(state.cart));
      },

      REMOVE_FROM_CART(state, productId) {
        const removedItem = state.cart.find(
          (item) => item.productId === productId
        );
        // Filter out the product to be removed
        state.cart = state.cart.filter((item) => item.productId !== productId);

        if (removedItem) {
          state.message = `${removedItem.name} removed from cart!`;
        }

        // Persist updated cart to localStorage
        localStorage.setItem("cart", JSON.stringify(state.cart));
      },

      // ✅ Clear the entire cart
      CLEAR_CART(state) {
        state.cart = [];
      },

      SET_MESSAGE(state, message) {
        state.message = message;
        setTimeout(() => {
          state.message = ""; // Clear message after a few seconds
        }, 3000);
      },
    },
    getters: {
      // ✅ Get total number of items in the cart
      cartItemCount: (state) => {
        return state.cart.reduce((total, item) => total + item.quantity, 0);
      },

      // ✅ Get all cart items
      cartItems: (state) => {
        return state.cart;
      },
    },
  });
  return store;
}
