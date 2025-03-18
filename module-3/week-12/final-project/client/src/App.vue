<template>
  <div id="app-container">
    <!-- Centered Logo -->
    <div id="logo-container">
      <img id="app-logo" src="/img/lion.png" alt="Logo" />
    </div>
    <!-- Navigation Bar (Now properly placed below the logo) -->
    <header id="navbar">
      <nav>
        <!-- Left Links -->
        <div class="nav-left">
          <router-link
            :to="{ name: 'home' }"
            :class="{ active: isActive('home') }"
          >
            Home
          </router-link>
          <router-link
            :to="{ name: 'cart' }"
            :class="{ active: isActive('cart') }"
          >
            Cart
          </router-link>
        </div>

        <!-- Message Area (Only visible when a message exists) -->
        <div v-if="message" class="nav-message">{{ message }}</div>

        <!-- Right Links -->
        <div class="nav-right">
          <router-link
            v-if="!isLoggedIn"
            :to="{ name: 'login' }"
            :class="{ active: isActive('login') }"
          >
            Login
          </router-link>
          <router-link
            v-if="isLoggedIn"
            :to="{ name: 'logout' }"
            :class="{ active: isActive('logout') }"
          >
            Logout
          </router-link>
        </div>
      </nav>
    </header>

    <!-- Main Content -->
    <div class="main-content">
      <router-view />
    </div>
    <footer id="products-footer">© Copyright All Right Reserved 2025</footer>
  </div>
</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
    message() {
      return this.$store.state.message;
    },
  },
  methods: {
    isActive(routeName) {
      return this.$route.name === routeName;
    },
  },
};
</script>

<style>
/* Ensure app container is properly stacked */
#app-container {
  background: linear-gradient(to bottom, #ffd700, #cc5500);
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  padding-bottom: 20px;
}

/* Center the logo */
#logo-container {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
  border-bottom: 2px solid black;
  margin-top: 0px; /* Add some spacing */
  background: linear-gradient(to bottom, #ffd700, #cc5500);
}

#app-logo {
  width: 600px; /* Adjust size */
  height: auto;
  background: linear-gradient(to bottom, #ffd700, #cc5500);
}

/* Move Navbar Below Logo */
#navbar {
  background-color: black;
  color: white;
  position: fixed;
  top: 120px; /* Positioned below the logo */
  left: 0;
  width: 100%;
  z-index: 999;
  padding: 10px 0;
  margin-top: 10px; /* Ensures navbar appears below the logo */
}

/* Adjust nav container */
nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 90%;
  margin: auto;
}

#navbar nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 95%;
  margin: auto;
}

/* Left and right nav sections */
.nav-left,
.nav-right {
  display: flex;
  gap: 15px;
}

.nav-left a,
.nav-right a {
  color: white;
  text-decoration: none;
  font-size: 1.2rem;
}

.nav-left a:hover,
.nav-right a:hover {
  text-decoration: underline;
}

/* Highlight active link */
.active {
  font-weight: bold;
  text-decoration: underline;
}

/* Message Area */
.nav-message {
  flex-grow: 1;
  text-align: center;
  font-size: 1.1rem;
  color: yellow;
  font-weight: bold;
}

/* ✅ Sticky Footer: Always on Top, Full-Width */
footer {
  position: fixed; /* Keep it always visible */
  bottom: 0; /* Stick to the bottom */
  left: 0;
  width: 100%; /* Full width */
  background-color: black; /* Match nav bar */
  color: white; /* Text color */
  text-align: center;
  padding: 10px 0; /* Padding for better visibility */
  font-size: 1.2rem;
  z-index: 1000; /* Ensure it's on top */
}

/* Ensure Main Content does not overlap the footer */
.main-content {
  flex-grow: 1;
  overflow-y: auto;
  margin-top: 160px; /* Pushes below fixed navbar */
  padding-bottom: 50px; /* Adjust for footer height */
  min-width: 300px;
}
</style>
