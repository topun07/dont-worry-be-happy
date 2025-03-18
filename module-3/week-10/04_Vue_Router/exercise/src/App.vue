<template>
  <div id="book-app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/myBooks">My Books</router-link> |
      <router-link to="/addBook">Add Book</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script>
export default {};
</script>

<style>
#book-app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}

nav {
  margin-bottom: 20px;
}

nav a {
  text-decoration: none;
  color: #007bff;
  font-weight: bold;
  margin: 0 10px;
}

nav a:hover {
  text-decoration: underline;
}
</style>
