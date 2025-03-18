<template>
  <form class="new-book-form" @submit.prevent="submitBook">
    <input
      type="text"
      class="title-input"
      v-model="newBook.title"
      placeholder="Book Title"
      required
    />
    <input
      type="text"
      class="author-input"
      v-model="newBook.author"
      placeholder="Author"
      required
    />
    <input
      type="text"
      class="isbn-input"
      v-model="newBook.isbn"
      placeholder="ISBN"
      required
    />
    <button type="submit">Add Book</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      newBook: {
        title: "",
        author: "",
        isbn: "",
        read: false, // Default new books as unread
      },
    };
  },
  methods: {
    submitBook() {
      if (!this.newBook.title || !this.newBook.author || !this.newBook.isbn)
        return;
      this.$emit("add-book", { ...this.newBook }); // Emit event to parent
      this.newBook = { title: "", author: "", isbn: "", read: false }; // Reset form
    },
  },
};
</script>

<style>
.new-book-form {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px; /* Space between elements */
  width: 100%;
  margin-top: 20px;
}

.title-input,
.author-input,
.isbn-input {
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 150px; /* Adjust width to make fields compact */
}

.save-button {
  padding: 5px 10px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: white;
  cursor: pointer;
}

.save-button:hover {
  background-color: #0056b3;
}
</style>
