import { createWebHistory, createRouter } from "vue-router";
import { RouteRecordRaw } from "vue-router";
import component from "./shims-vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    alias: "/tutorials",
    name: "tutorials",
    component: () => import("./components/TutorialsList.vue"),
  },
  {
    path: "/tutorials/:id",
    name: "tutorial-details",
    component: () => import("./components/TutorialDetails.vue"),
  },
  {
    path: "/product",
    name: "product",
    component: () => import("./components/ListeProduit.vue"),
  },
  {
    path: "/updateproduct/:id/:name/:price/:description",
    name: "updateproduct",
    component: () => import("./components/UpdateProduct.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
