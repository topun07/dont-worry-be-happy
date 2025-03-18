<template>
  <div>
    <h2>Add a New Book</h2>
    <NewBookForm />
  </div>
</template>

<script>
import NewBookForm from "@/components/NewBookForm.vue"; // Ensure the correct import path

export default {
  name: "NewBookView",
  components: {
    NewBookForm,
  },
};
</script>

<style scoped>
h2 {
  text-align: center;
  margin-top: 20px;
}
</style>
