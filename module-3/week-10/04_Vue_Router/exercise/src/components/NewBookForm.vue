<template>
  <form class="new-book-form" @submit.prevent="saveBook">
    <input
      class="title-input"
      type="text"
      placeholder="Title"
      v-model="book.title"
      required
    />
    <input
      class="author-input"
      type="text"
      placeholder="Author"
      v-model="book.author"
      required
    />
    <input
      class="isbn-input"
      type="text"
      placeholder="ISBN"
      v-model="book.isbn"
      required
    />
    <input
      type="number"
      placeholder="Num Pages"
      v-model="book.numPages"
      required
    />
    <input
      type="url"
      placeholder="More Info Link"
      v-model="book.moreInfoLink"
      required
    />
    <button type="submit">Save</button>
  </form>
</template>

<script>
import { useRouter } from "vue-router";
import { useStore } from "vuex";

export default {
  setup() {
    const store = useStore();
    const router = useRouter();

    const book = {
      title: "",
      author: "",
      isbn: "",
      numPages: null,
      moreInfoLink: "",
    };

    const saveBook = () => {
      if (!book.title || !book.author || !book.isbn) return; // Prevent empty submission
      store.commit("SAVE_BOOK", { ...book });

      router.push("/myBooks"); // Navigate to MyBooksView after saving
    };

    return { book, saveBook };
  },
};
</script>

<style>
.new-book-form {
  margin: 20px;
}

.new-book-form input,
.new-book-form button {
  margin: 10px;
  font-size: 1rem;
}
</style>
