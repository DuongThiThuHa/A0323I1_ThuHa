<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Our Categories</h3>
        <router-link :to="{ name: 'AddCategory' }">
          <button class="btn" style="float:right">Add Category</button>
        </router-link>
      </div>
    </div>c
    <div class="row">
      <div
          v-for="category of categories"
          :key="category.id"
          class="col-xl-4 col-md-6 col-12 pt-3 d-flex"
      >
        <CategoryBox :category="category"> </CategoryBox>
      </div>
    </div>
  </div>
</template>

<script>
// import axios from "axios";
const axios = require("axios");
import CategoryBox from "../../components/Category/CategoryBox.vue";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Category",
  components: { CategoryBox },
  data() {
    return {
      baseURL: "http://localhost:8443/swagger-ui.html#",
      categories: [],
    };
  },
  methods: {
    async getCategories() {
      try {
        const response = await axios.get(`${this.baseURL}/category/`);
        this.categories = response.data;
      } catch (error) {
        console.error("Error fetching categories:", error);
      }
    },
  },
  mounted() {
    this.getCategories();
  },
};
</script>

<style scoped></style>
