<template>
  <div>
    <h2>Best Sellers</h2>
    <BestSellerList />

    <h2>New Releases</h2>
    <NewReleasesList />
  </div>
</template>

<script>
import BestSellerList from "@/components/BestSellerList.vue";
import NewReleasesList from "@/components/NewReleasesList.vue";

export default {
  name: "HomeView",
  components: {
    BestSellerList,
    NewReleasesList,
  },
};
</script>

<style scoped>
h2 {
  text-align: center;
  margin-top: 20px;
}
</style>
