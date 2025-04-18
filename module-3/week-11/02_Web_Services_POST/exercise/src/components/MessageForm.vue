<template>
  <form v-on:submit.prevent="submitForm">
    <div class="field">
      <label for="title">Title</label>
      <input type="text" id="title" name="title" v-model="editMessage.title" />
    </div>
    <div class="field">
      <label for="messageText">Message</label>
      <textarea
        id="messageText"
        name="messageText"
        v-model="editMessage.messageText"
      />
    </div>
    <div class="actions">
      <button class="btn-submit" type="submit">Submit</button>
      <button class="btn-cancel" type="button" v-on:click="cancelForm">
        Cancel
      </button>
    </div>
  </form>
</template>

<script>
import messageService from "../services/MessageService.js";

export default {
  props: {
    message: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      // Since props are read-only, don't bind to props directly.
      // Instead, initialize a new object with the same property values.
      editMessage: {
        id: this.message.id,
        topicId: this.message.topicId,
        created: this.message.created,
        title: this.message.title,
        messageText: this.message.messageText,
      },
    };
  },
  methods: {
    submitForm() {
      // Do client-side form validation
      if (!this.validateForm()) {
        return; // Form isn't valid, user must update and submit again.
      }

      // Check if adding or updating a message
      if (!this.editMessage.id) {
        // ✅ Creating a new message
        messageService
          .create(this.editMessage)
          .then((response) => {
            if (response.status === 201) {
              // Ensure successful creation
              this.$router.push({
                name: "TopicDetailsView",
                params: { topicId: this.editMessage.topicId },
              });
            } else {
              throw new Error("Unexpected response status: " + response.status);
            }
          })
          .catch((error) => {
            this.handleErrorResponse(error, "adding");
          });
      } else {
        // ✅ Updating an existing message
        messageService
          .update(this.editMessage.id, this.editMessage)
          .then((response) => {
            if (response.status === 200) {
              // Ensure successful update
              this.$router.push({
                name: "MessageDetailsView",
                params: { messageId: this.editMessage.id },
              });
            } else {
              throw new Error("Unexpected response status: " + response.status);
            }
          })
          .catch((error) => {
            this.handleErrorResponse(error, "updating");
          });
      }
    },
    cancelForm() {
      this.$router.back();
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFoundView" });
        } else {
          this.$store.commit(
            "SET_NOTIFICATION",
            `Error ${verb} message. Response received was "${error.response.statusText}".`
          );
        }
      } else if (error.request) {
        this.$store.commit(
          "SET_NOTIFICATION",
          `Error ${verb} message. Server could not be reached.`
        );
      } else {
        this.$store.commit(
          "SET_NOTIFICATION",
          `Error ${verb} message. Request could not be created.`
        );
      }
    },
    validateForm() {
      let msg = "";

      this.editMessage.title = this.editMessage.title.trim();
      if (this.editMessage.title.length === 0) {
        msg += "The new message must have a title. ";
      }

      this.editMessage.messageText = this.editMessage.messageText.trim();
      if (this.editMessage.messageText.length === 0) {
        msg += "The message must contain message text.";
      }

      if (msg.length > 0) {
        this.$store.commit("SET_NOTIFICATION", msg);
        return false;
      }
      return true;
    },
  },
};
</script>

<style></style>
