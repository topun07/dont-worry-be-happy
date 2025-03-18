<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <header class="flex">
      <h1>Topics</h1>
      <button
        class="btn-add"
        v-on:click="$router.push({ name: 'AddTopicView' })"
      >
        Add Topic
      </button>
    </header>
    <topic-list v-if="topics.length > 0" v-bind:topics="topics" />
    <p v-else>No topics available.</p>
  </div>
</template>

<script>
import topicService from "../services/TopicService.js";
import TopicList from "../components/TopicList.vue";

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
      topicService
        .list()
        .then((response) => {
          this.topics = response.data;
          this.isLoading = false;
        })
        .catch((error) => {
          console.error("Error fetching topics:", error); // Log error details
          this.handleErrorResponse();
        });
    },
    handleErrorResponse(error) {
      this.isLoading = false;
      const message =
        error?.response?.data?.message ||
        "Could not get topic data from server.";
      this.$store.commit("SET_NOTIFICATION", message);
    },
  },
  created() {
    this.getTopics();
  },
};
</script>

<style scoped></style>
