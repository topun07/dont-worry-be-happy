import axios from "axios";

const API_BASE_URL = "http://localhost:3000";

export default {
  list() {
    return axios
      .get(`${API_BASE_URL}/topics`)
      .then((response) => response.data);
  },
  get(id) {
    // ✅ New method to fetch a single topic
    return axios
      .get(`${API_BASE_URL}/topics/${id}`)
      .then((response) => response.data);
  },
};
