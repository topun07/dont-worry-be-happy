<!-- BookCard.vue -->
<template>
  <div class="card" :class="{ read: book.read }">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img
      class="book-image"
      v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
      "
      alt="Book Cover"
    />
    <button
      :class="book.read ? 'mark-unread' : 'mark-read'"
      @click="toggleReadStatus"
    >
      {{ book.read ? "Mark Unread" : "Mark Read" }}
    </button>
  </div>
</template>

<script>
export default {
  props: {
    book: Object,
  },
  methods: {
    toggleReadStatus() {
      this.$emit("toggle-read", this.book.isbn); // Make sure event is emitted
    },
  },
};
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 450px;
  margin: 20px;
  padding: 10px;
  text-align: center;
  background-color: #fff;
  transition: background-color 0.3s;
}

.card.read {
  background-color: lightgray;
}

.book-title {
  font-size: 1.5rem;
  margin-bottom: 5px;
}

.book-author {
  font-size: 1rem;
  margin-bottom: 10px;
  color: #555;
}

.book-image {
  width: 80%;
  height: auto;
  margin-top: 10px;
  border-radius: 5px;
}

.mark-read,
.mark-unread {
  display: block;
  width: 80%;
  margin: 15px auto;
  padding: 8px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
}

.mark-read {
  background-color: #28a745;
  color: white;
}

.mark-unread {
  background-color: #dc3545;
  color: white;
}

.mark-read:hover {
  background-color: #218838;
}

.mark-unread:hover {
  background-color: #c82333;
}
</style>
