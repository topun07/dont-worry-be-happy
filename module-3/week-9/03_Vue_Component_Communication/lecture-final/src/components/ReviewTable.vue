<template>
  <table>
    <thead>
      <tr>
        <th>Title</th>
        <th>Reviewer</th>
        <th>Review</th>
        <th>Rating</th>
        <th>Favorited</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="review in filteredReviews" 
          v-bind:key="review.id" 
          v-bind:class="{ favorited: review.favorited}">
        <td>{{ review.title }}</td>
        <td nowrap>{{ review.reviewer }}</td>
        <td>{{ review.review }}</td>
        <td class="stars">
          <img
                src="../assets/star.png"
                class="star"
                v-bind:title="review.rating + ' Star Review'"
                v-for="n in review.rating"
                v-bind:key="n"
                width="20"
              />
        </td>
        <td>
          <input type="checkbox" name="favorite-checkbox"
                 v-bind:checked="review.favorited"
                 v-on:change="onFavoritedChange(review)" />
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  methods: {
    onFavoritedChange(review) {
      this.$store.commit('FLIP_FAVORITED', review);
    }
  },
  computed: {
    filteredReviews() {
      const reviewFilter = this.$store.state.filter;
      return this.$store.state.reviews.filter(review => {
        return reviewFilter === 0 || reviewFilter === review.rating;
    });
    }
  }
  
};
</script>



<style scoped>
  th,
  td {
    text-align: left;
  }
  td {
    padding-right: 10px;
    vertical-align: top;
  }
  tr:nth-child(even) {
    background-color: rgb(238, 238, 238);
  }
  /*
  Table rows are awkward to apply a border to. outline is a good alternative that provides
  a similar visual effect and doesn't affect the page layout
  */
  .favorited {
    outline: 3px solid rgba(255, 255, 0, 0.5);
  }
  .stars {
    display: flex;
  }
</style>
