<template>
  <div id="product-details">
    <!-- Product Details Container -->
    <div class="product-container">
      <!-- Left Side: Product Info -->
      <div class="product-info">
        <h1>{{ product.name }}</h1>
        <h2>Details</h2>
        <p><strong>SKU:</strong> {{ product.productSku }}</p>
        <p><strong>Price:</strong> ${{ product.price }}</p>
        <p>{{ product.description }}</p>
        <img
          :src="getProductImage(product.imageName)"
          alt="Product Image"
          class="product-image"
        />
      </div>

      <!-- Right Side: Add to Cart Button -->
      <div class="add-to-cart">
        <button @click="addToCart(product)" class="cart-button">
          <font-awesome-icon icon="fa-solid fa-cart-plus" /> Add to Cart
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";

export default {
  props: ["id"],
  data() {
    return {
      product: {},
      message: "",
    };
  },
  created() {
    this.fetchProduct();
  },
  computed: {
    ...mapState(["cart"]),
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  },
  methods: {
    ...mapMutations(["ADD_TO_CART", "SET_MESSAGE"]),
    fetchProduct() {
      const productId = this.$route.params.id;
      fetch(`http://localhost:9000/products/${productId}`)
        .then((response) => response.json())
        .then((data) => {
          this.product = data;
        })
        .catch((error) => console.error("Error fetching product:", error));
    },

    addToCart(product) {
      if (!this.isLoggedIn) {
        this.message = "You must be logged in to add items to the cart!";
        return;
      }
      this.ADD_TO_CART(product);
      this.message = `${product.name} added to cart!`;
      setTimeout(() => {
        this.message = "";
      }, 2000);
    },
    getProductImage(imageName) {
      return imageName
        ? `/img/${imageName.replace("/img/", "")}`
        : "/img/product_350x250.jpg";
    },

    created() {
      this.fetchProduct();
    },
  },
};
</script>

<style scoped>
#product-details {
  background: linear-gradient(to bottom, #cc5500, #ffd700);
  min-height: 500px;
  display: flex;
  flex-direction: column;
  align-items: left;
  padding: 20px;
  position: relative;
}

#app-logo {
  width: 200px;
}

/* Product Details */
.product-container {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  width: 80%;
  max-width: 900px;
  background: white;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  margin-top: 70px;
}

/* Product Info (Left Side) */
.product-info {
  flex: 1;
}

.product-info h1 {
  font-size: 1.8rem;
}

.product-info p {
  font-size: 1.2rem;
  margin-bottom: 5px;
}

.product-image {
  width: 100%;
  max-width: 300px;
  margin-top: 10px;
}

.add-to-cart {
  display: flex;
  align-items: flex-start;
  justify-content: flex-end;
  width: 50%;
}

.cart-button {
  background-color: gold;
  color: black;
  border: none;
  font-size: 1.2rem;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 10px;
}

.cart-button:hover {
  background-color: darkgreen;
}
</style>
