<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <nav>
      <router-link v-bind:to="{ name: 'HomeView' }">
        Back to Topic List
      </router-link>
    </nav>
    <header v-if="topic && topic.title">
      <h1>{{ topic.title }}</h1>
      <!-- ✅ Ensure topic.title is available -->
    </header>
    <topic-details v-bind:topic="topic" />
  </div>
</template>

<script>
import TopicDetails from "../components/TopicDetails.vue";
import TopicService from "../services/TopicService.js";

export default {
  components: {
    TopicDetails,
  },
  data() {
    return {
      topic: null,
      isLoading: true,
    };
  },
  methods: {
    getTopic() {
      const topicId = this.$route.params.topicId; // ✅ Corrected ID retrieval
      console.log("Topic ID from route:", topicId); // ✅ Log topic ID

      if (!topicId) {
        console.error("Error: topicId is undefined!");
        return;
      }

      TopicService.get(topicId)
        .then((response) => {
          console.log("API Response:", response); // ✅ Log API response
          this.topic = response;
          this.isLoading = false;
        })
        .catch((error) => {
          console.error("Error fetching topic details:", error);
        });
    },
  },
  created() {
    this.getTopic();
  },
};
</script>

<style scoped></style>
