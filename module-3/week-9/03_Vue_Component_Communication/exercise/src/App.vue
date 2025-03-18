<template>
  <div id="book-app">
    <h1>Reading List</h1>
    <div class="content-container">
      <ReadingList />
    </div>
    <NewBookForm @add-book="addNewBook" />
  </div>
</template>

<script>
import ReadingList from "./components/ReadingList.vue";
import NewBookForm from "./components/NewBookForm.vue";
import { mapActions } from "vuex";

export default {
  components: {
    ReadingList,
    NewBookForm,
  },
  methods: {
    ...mapActions(["addBook"]),
    addNewBook(book) {
      this.addBook(book); // Calls Vuex action to update state
    },
  },
};
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
</style>
