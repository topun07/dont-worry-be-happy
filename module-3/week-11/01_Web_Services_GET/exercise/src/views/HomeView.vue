<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <header class="flex">
      <h1>Topics</h1>
    </header>
    <topic-list v-bind:topics="topics" />
  </div>
</template>

<script>
import TopicList from "../components/TopicList.vue";
import TopicService from "../services/TopicService.js"; // ✅ Add this import

export default {
  components: {
    TopicList,
  },
  data() {
    return {
      topics: [],
      isLoading: true,
    };
  },
  methods: {
    getTopics() {
      TopicService.list()
        .then((response) => {
          this.topics = response; // Assign API response to topics
          this.isLoading = false; // Set loading to false
        })
        .catch((error) => {
          console.error("Error fetching topics:", error);
        });
    },
  },
  created() {
    this.getTopics(); // Fetch topics when component is created
  },
};
</script>

<style scoped></style>
