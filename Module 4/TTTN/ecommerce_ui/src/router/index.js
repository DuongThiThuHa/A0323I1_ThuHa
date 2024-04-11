import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from '../views/Category/AddCategory.vue'
import Category from "../views/Category/Category.vue";

Vue.use(VueRouter)

const routes = [
    // Home Page
  {
    path: '/',
    name: 'home',
    component: HomeView
  },

    // About Page
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },

    // Add Category
  {
    path: '/admin/Category/add',
    name: 'AddCategory',
    component: AddCategory
  },

    // Category
  {
    path: '/admin/Category',
    name: 'Category',
    component: Category
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
