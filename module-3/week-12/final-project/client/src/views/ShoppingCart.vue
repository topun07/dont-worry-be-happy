<template>
  <div id="shopping-cart">
    <div class="cart-container">
      <h1>Shopping Cart</h1>

      <table v-if="cart.length > 0" class="cart-table">
        <thead>
          <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in cart" :key="item.productSku">
            <td>{{ item.name }}</td>
            <td>{{ item.quantity }}</td>
            <td>${{ item.price.toFixed(2) }}</td>
            <td>${{ (item.quantity * item.price).toFixed(2) }}</td>
            <td>
              <font-awesome-icon
                icon="fa-solid fa-xmark"
                class="remove-icon"
                title="Remove item"
                v-on:click="removeFromCart(item.productId)"
              />
            </td>
          </tr>
        </tbody>
      </table>

      <div v-else class="empty-cart">Your cart is empty.</div>

      <div class="cart-summary" v-if="cart.length > 0">
        <p>Subtotal: ${{ subtotal.toFixed(2) }}</p>
        <p>Tax: ${{ tax.toFixed(2) }}</p>
        <p>
          <strong>Total: ${{ total.toFixed(2) }}</strong>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    cart() {
      return this.$store.state.cart || []; // Ensure cart always exists
    },
    subtotal() {
      return this.cart.reduce(
        (sum, item) => sum + item.quantity * item.price,
        0
      );
    },
    tax() {
      return this.subtotal * 0.08;
    },
    total() {
      return this.subtotal + this.tax;
    },
  },
  methods: {
    removeFromCart(productId) {
      this.$store.commit("REMOVE_FROM_CART", productId); // ✅ Calls Vuex mutation
    },
  },
};
</script>

<style scoped>
/* Gradient Background */
#shopping-cart {
  background: linear-gradient(to bottom, #ffd700, #cc5500);
  min-height: 650px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
  position: relative;
  min-width: 200px;
}

#navbar nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 97%;
  background-color: black;
  color: white;
  padding: 10px 20px;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1000;
}

.nav-left,
.nav-right {
  display: flex;
  align-items: center;
}

.nav-left a,
.nav-right a {
  color: white;
  text-decoration: none;
  margin: 0 15px;
  font-size: 1.2rem;
}

.nav-left a:hover,
.nav-right a:hover {
  text-decoration: underline;
}

#logo-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  margin-top: 60px;
}

#cart-logo {
  position: center;
  top: auto;
  right: auto;
  width: 400px;
  height: 70px;
  padding: 20px;
}

.cart-container {
  width: 80%;
  max-width: 900px;
  border: 10px solid black;
  padding: 40px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  text-align: center;
  margin: auto;
  margin-top: 20px;
  min-width: 400px;
}

.cart-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.cart-table th,
.cart-table td {
  border: 1px solid black;
  padding: 10px;
}

.cart-table th {
  background-color: #ddd;
}

.cart-summary {
  margin-top: 20px;
  font-size: 1.2rem;
}

#cart-footer {
  background-color: black;
  color: white;
  text-align: center;
  font-size: 1.5rem;
  padding: 10px;
  margin-top: 20px;
}

.remove-icon {
  color: white; /* Make it red */
  font-size: 1.8rem; /* Make it slightly bigger */
  background: orange;
  cursor: pointer; /* Show pointer on hover */
  transition: color 0.3s ease;
}

.remove-icon:hover {
  color: darkred; /* Darker red on hover */
}
</style>
