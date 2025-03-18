<!-- ReadingList.vue -->
<template>
  <div class="book-container">
    <BookCard
      v-for="book in books"
      :key="book.isbn"
      :book="book"
      @toggle-read="toggleReadStatus"
    />
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import BookCard from "./BookCard.vue";

export default {
  components: {
    BookCard,
  },
  computed: {
    ...mapState(["books"]),
  },
  methods: {
    ...mapActions(["toggleReadStatus"]),
  },
};
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  gap: 20px;
}
</style>
