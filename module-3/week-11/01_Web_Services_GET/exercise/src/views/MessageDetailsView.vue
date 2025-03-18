<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <nav>
      <router-link
        v-bind:to="{
          name: 'TopicDetailsView',
          params: { topicId: message.topicId },
        }"
      >
        Back to Topic
      </router-link>
    </nav>
    <header v-if="message && message.title">
      <h1>{{ message.title }}</h1>
    </header>
    <p>{{ message.messageText }}</p>
  </div>
</template>

<script>
import MessageService from "../services/MessageService.js";

export default {
  data() {
    return {
      message: null,
      isLoading: true,
    };
  },
  methods: {
    getMessage() {
      const messageId = this.$route.params.messageId; // ✅ Corrected parameter name
      console.log("Fetching message ID:", messageId); // ✅ Log message ID

      if (!messageId) {
        console.error("Error: messageId is undefined!");
        return;
      }

      MessageService.get(messageId)
        .then((response) => {
          console.log("API Response:", response); // ✅ Log API response
          this.message = response;
          this.isLoading = false;
        })
        .catch((error) => {
          console.error("Error fetching message details:", error);
        });
    },
  },
  created() {
    this.getMessage();
  },
};
</script>

<style scoped></style>
