import { createRouter as _createRouter, createWebHistory } from "vue-router";
import HomeView from "@/components/HomeView.vue";
import MyBooksView from "@/components/MyBooksView.vue";
import NewBookView from "@/components/NewBookView.vue";
import BookDetails from "@/components/BookDetails.vue";

const routes = [
  { path: "/", name: "Home", component: HomeView },
  { path: "/myBooks", name: "MyBooks", component: MyBooksView },
  { path: "/addBook", name: "NewBook", component: NewBookView },
  {
    path: "/book/:isbn",
    name: "BookDetails",
    component: BookDetails,
    props: true,
  },
];

export function createRouter() {
  return _createRouter({
    history: createWebHistory(),
    routes: routes,
  });
}
