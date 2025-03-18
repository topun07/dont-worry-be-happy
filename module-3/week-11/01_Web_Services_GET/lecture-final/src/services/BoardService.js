import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getBoard(boardId) {
    return http.get(`/boards/${boardId}`)
  },

  getCard(cardId) {
    return http.get(`/cards/${cardId}`)
  }

}
