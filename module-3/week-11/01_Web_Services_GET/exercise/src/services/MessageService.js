import axios from "axios";

const API_BASE_URL = "http://localhost:3000";

export default {
  getMessagesByTopic(topicId) {
    return axios
      .get(`${API_BASE_URL}/messages`, { params: { topicId } })
      .then((response) => response.data);
  },
  get(messageId) {
    // ✅ New method to fetch a single message
    return axios
      .get(`${API_BASE_URL}/messages/${messageId}`)
      .then((response) => response.data);
  },
};
