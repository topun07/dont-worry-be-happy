<template>
  <div class="book-details">
    <router-link to="/">Home</router-link> |
    <router-link to="/myBooks">My Books</router-link>

    <h2>{{ book.title }}</h2>
    <h3>{{ book.author }}</h3>

    <img
      class="book-image"
      :src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-L.jpg'"
      alt="Book Cover"
    />

    <p><strong>Number of pages:</strong> {{ book.numPages }}</p>
    <p>
      <a :href="book.moreInfoLink" target="_blank">More Information</a>
    </p>

    <button @click="markAsRead">I have read this book</button>
  </div>
</template>

<script>
import { useStore } from "vuex";
import { useRoute } from "vue-router";

export default {
  setup() {
    const store = useStore();
    const route = useRoute();

    // Find book based on ISBN from route params
    const book = store.state.books.find((b) => b.isbn === route.params.isbn);

    const markAsRead = () => {
      store.commit("MARK_BOOK_AS_READ", book.isbn);
    };

    return { book, markAsRead };
  },
};
</script>

<style scoped>
.book-details {
  text-align: center;
  margin: 20px;
}

.book-image {
  width: 100%;
  max-width: 300px;
  margin: 20px 0;
}

button {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px;
  cursor: pointer;
  font-size: 1rem;
}

button:hover {
  background-color: #0056b3;
}
</style>
