<template>
  <div id="app-container">
    <!-- Main Content -->
    <div class="main-content">
      <div class="products-container">
        <h1>
          Products
          <loading-spinner id="spinner" v-bind:spin="isLoading" />
        </h1>
        <input
          type="text"
          id="search-box"
          placeholder="Search products..."
          v-model="searchTerm"
        />
        <p id="login-message" v-if="!isLoggedIn">
          Welcome! You may browse anonymously as much as you wish,<br />
          but you must
          <router-link v-bind:to="{ name: 'login' }">Login</router-link> to add
          items to your shopping cart.
        </p>
      </div>

      <p v-if="!isLoggedIn" class="login-message">
        Welcome. You may browse anonymously as much as you wish, but you must
        <router-link v-bind:to="{ name: 'login' }" class="login-link"
          >Login</router-link
        >
        to add items to your shopping cart.
      </p>

      <div class="view-toggle">
        <font-awesome-icon
          v-bind:class="{ 'view-icon': true, active: cardView }"
          v-on:click="setView('card')"
          icon="fa-solid fa-grip"
          title="View tiles"
        />
        <font-awesome-icon
          v-bind:class="{ 'view-icon': true, active: !cardView }"
          v-on:click="setView('table')"
          icon="fa-solid fa-table"
          title="View table"
        />
      </div>

      <!-- Tile View -->
      <div v-if="cardView" class="card-view">
        <div
          v-for="product in filteredProducts"
          :key="product.productId"
          class="product-card"
        >
          <!-- SKU and Price -->
          <div class="product-details">
            <span class="sku">{{ product.productSku }}</span>
            <span class="price">${{ product.price }}</span>
          </div>

          <!-- ✅ Product Name is now the clickable link -->
          <h3>
            <router-link :to="`/product/${product.productId}`">{{
              product.name
            }}</router-link>
          </h3>

          <!-- Product Image (Not Clickable) -->
          <img
            :src="getProductImage(product.imageName)"
            alt="Product Image"
            class="product-image"
          />

          <!-- Add to Cart Button -->
          <font-awesome-icon
            v-if="isLoggedIn"
            icon="fa-solid fa-cart-plus"
            class="cart-icon"
            title="Add to cart"
            v-on:click="addToCart(product)"
          />
        </div>
      </div>

      <!-- Table View -->
      <table v-else class="table-view">
        <thead>
          <tr>
            <th>SKU</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th v-if="isLoggedIn">Add to Cart</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="product in filteredProducts" :key="product.productId">
            <td>{{ product.productSku }}</td>
            <td>
              <router-link :to="`/product/${product.productId}`">{{
                product.name
              }}</router-link>
            </td>
            <td>{{ product.description }}</td>
            <td>${{ product.price }}</td>
            <td v-if="isLoggedIn">
              <font-awesome-icon
                icon="fa-solid fa-cart-plus"
                class="cart-icon"
                title="Add to cart"
                v-on:click="addToCart(product)"
              />
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import LoadingSpinner from "../components/LoadingSpinner.vue";
export default {
  components: {
    LoadingSpinner,
  },
  data() {
    return {
      isLoading: false,
      cardView: true,
      searchTerm: "",
      products: [],
    };
  },

  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
    filteredProducts() {
      return this.products.filter((product) =>
        product.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    },
  },
  methods: {
    async fetchProducts() {
      this.isLoading = true;
      try {
        const response = await axios.get("http://localhost:9000/products");
        this.products = response.data;
      } finally {
        this.isLoading = false;
      }
    },
    setView(view) {
      this.cardView = view === "card";
    },

    addToCart(product) {
      if (!this.isLoggedIn) {
        this.message = "You must be logged in to add items to the cart!";
        return;
      }

      // ✅ Add product to cart using Vuex
      this.$store.commit("ADD_TO_CART", product);

      // ✅ Set message in the message bar instead of a popup
      this.$store.commit("SET_MESSAGE", `${product.name} added to cart!`);

      // ✅ Clear message after 3 seconds
      setTimeout(() => {
        this.$store.commit("CLEAR_MESSAGE");
      }, 3000);
    },

    getProductImage(imageName) {
      if (!imageName) {
        return "/img/product_350x250.jpg"; // Fallback image
      }
      // Fix: Ensure there are no duplicate `/img/` in the path
      return imageName.startsWith("/img/")
        ? imageName
        : `/img/${imageName.replace(/^\/img\//, "")}`;
    },

    // ✅ Ensure `isActive()` method exists
    isActive(routeName) {
      return this.$route.name === routeName;
    },
  },

  created() {
    this.fetchProducts(); // Fetch products when component loads
  },
};
</script>

<style scoped>
/* Adjust Main Content */
.main-content {
  width: 100%;
  max-width: 100%;
  margin-top: 20px; /* Push main content down */
  background: linear-gradient(to bottom, #cc5500, #ffd700);
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

/* App Container */
#app-container {
  background: linear-gradient(to bottom, #cc5500, #ffd700);
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* Center the Logo */
#logo-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  margin-top: 20px;
}

#app-logo {
  width: 200px;
  height: auto;
}

/* ✅ Move Navbar Below Logo */
#navbar {
  width: 100%;
  margin-top: 10px; /* Add space between logo and navbar */
  background-color: black;
  padding: 10px 0;
}

#navbar nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 90%;
  margin: auto;
}

/* ✅ Message Styling */
.nav-message {
  flex-grow: 1;
  text-align: center;
  font-size: 1.2rem;
  color: white;
  background-color: rgba(255, 255, 255, 0.2);
  padding: 5px 10px;
  border-radius: 5px;
}

.nav-left a,
.nav-right a {
  color: white;
  text-decoration: none;
  margin-right: 15px;
  font-size: 1.2rem;
}

.nav-left a:hover,
.nav-right a:hover {
  text-decoration: underline;
}
#spinner {
  color: green;
}

#search-box {
  width: 80%;
  max-width: 500px;
  padding: 10px;
  margin: 20px 0;
  border: 2px solid black;
  border-radius: 5px;
}

.view-toggle {
  margin-top: 20px;
}

.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
  transition: 0.3s;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}

#products {
  background: linear-gradient(to bottom, #ffd700, #cc5500);
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
  position: relative;
}

#products-logo {
  position: center;
  top: auto;
  right: auto;
  width: 400px;
  height: 70px;
  padding: 20px;
  margin-top: 60px;
}

#products-header,
#products-footer {
  background-color: black;
  color: white;
  text-align: center;
  font-size: 1.5rem;
  padding: 10px;
  margin-bottom: 10px;
  display: flex;
}

.products-container {
  width: 80%;
  margin: 20px;
  max-width: 900px;
  border: 10px solid black;
  padding: 40px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.card-view {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
  margin-top: 20px;
}

.product-card {
  background-color: #f5f5f5;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

/* Grid View */
.grid-view {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
  margin-top: 20px;
}

/* Product Cards */
.product-card {
  background-color: #f5f5f5;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  text-align: center;
  position: relative;
}

/* SKU and Price */
.product-details {
  display: flex;
  justify-content: space-between;
  font-weight: bold;
}

/* Product Image */
.product-image {
  width: 100%;
  height: auto;
  margin-top: 10px;
}

.cart-icon {
  font-size: 1.5rem;
  color: green;
  cursor: pointer;
  bottom: 10px;
  right: 10px;
}

.table-view {
  width: 100%;
  margin-top: 20px;
  border-collapse: collapse;
}

.table-view th,
.table-view td {
  border: 1px solid black;
  padding: 10px;
}

.table-view th {
  background-color: #ddd;
}

/* Shopping Cart Icon */
.cart-icon {
  font-size: 1.5rem;
  margin-left: 10px;
  cursor: pointer;
  color: green;
  transition: 0.3s;
}

.cart-icon:hover {
  color: darkgreen;
}
</style>
