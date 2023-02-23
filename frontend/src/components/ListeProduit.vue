<template>
    <div class="app">
        <h1>CRUD Produit test Mada dev</h1>
        <h2>Créer une nouveau produit</h2>
        <form @submit.prevent="formCreation">
            <label for="name">Name :</label>
            <input type="text" id="price" name="price" v-model="name" required>
            <label for="price">Price :</label>
            <input type="text" id="price" name="price" v-model="price" required>
            <label for="description">Description :</label>
            <input id="description" name="description" v-model="description">
            <button type="submit">Créer</button>
        </form>
        <h2>Liste des produits</h2>
        <table class="styled-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in products " :key="item.id" class="active-row">
                    <td>{{ item.name }}</td>
                    <td>{{ item.price }} Ar</td>
                    <td>{{ item.description }}</td>
                    <td>
                        <button>Editer</button>
                        <form @submit.prevent="formDelete(item.id)">
                            <button>Supprimer</button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script lang="ts">

import { defineComponent, ref } from 'vue';
import { getProduct, createProduct, deleteProduct } from '@/service/productService.api';
export default defineComponent({
    data() {
        return {
            products: null,
        }
    },
    async created() {
        try {
            const result = await getProduct();
            this.products = result?.data
            console.log(this.products)
        } catch (error) {
            console.log(error);
        }
    },
    methods: {
        async formCreation() {
            try {
                await createProduct(this.name, this.price, this.description);
            } catch (error) {
                console.log(error);
            }
        },
        async formDelete(id: any) {
            try {
                await deleteProduct(id);
            } catch (error) {
                console.log(error);
            }
        }
        // ,
        // async formUpdate() {
        //     try {
        //         await updateProduct(this.id, this.name, this.price, this.description)
        //     } catch (error) {
        //         console.log(error);
        //     }
        // }
    }
});
</script>