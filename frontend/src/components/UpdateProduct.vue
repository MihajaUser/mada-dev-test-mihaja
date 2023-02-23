<template>
  <h1>Modification produit</h1>
  <br />
  <form @submit.prevent="formUpdate">
    <label for="name">Name :</label>
    <input type="text" id="price" name="price" v-model="name" required />
    <label for="price">Price :</label>
    <input type="text" id="price" name="price" v-model="price" required />
    <label for="description">Description :</label>
    <input id="description" name="description" v-model="description" />
    <button type="submit" class="buttonUpdate">Modifier</button>
  </form>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import {
  updateProduct
} from "@/services/productService.api";

export default defineComponent({
  name: "updateproduct",
  data() {
    return {
      id: {},
      name: {},
      price: {},
      description: {},
    };
  }, async created() {
    this.id = this.$route.params.id;
    this.name = this.$route.params.name;
    this.price = this.$route.params.price;
    this.description = this.$route.params.description;
  },
  methods: {
    async formUpdate() {
      try {
        await updateProduct(this.id, this.name, this.price, this.description);
      } catch (error) {
        console.log(error);
      }
    }
  },
});
</script>
<style>
.buttonUpdate {
  margin-left: 20px;
  border-radius: 10px;
  background-color: #887f7f;
}
input{
  border-radius: 7px;
  margin-left: 20px;
}
</style>

 
