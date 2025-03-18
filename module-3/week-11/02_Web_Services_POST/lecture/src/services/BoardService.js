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
  },

  addCard(card) {
    return http.post('/cards', card);
  },

  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardId) {
    return http.delete(`/cards/${cardId}`);
  }

}
