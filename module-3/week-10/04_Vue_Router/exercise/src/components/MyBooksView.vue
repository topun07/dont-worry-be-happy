<template>
  <div>
    <h2>My Reading List</h2>
    <ReadingList />
    <div class="add-book-link">
      <router-link to="/addBook">Add Book to Reading List</router-link>
    </div>
  </div>
</template>

<script>
import ReadingList from "@/components/ReadingList.vue";

export default {
  name: "MyBooksView",
  components: {
    ReadingList,
  },
};
</script>

<style scoped>
h2 {
  text-align: center;
  margin-top: 20px;
}

.add-book-link {
  text-align: center;
  margin-top: 20px;
}

.add-book-link a {
  text-decoration: none;
  color: #007bff;
  font-weight: bold;
}

.add-book-link a:hover {
  text-decoration: underline;
}
</style>
