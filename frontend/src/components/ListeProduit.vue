<template>
    <div class="app">
        <h1>CRUD Produit test Mada dev</h1>
        <h2>Créer une nouveau produit</h2>
        <form @submit.prevent="formCreation">
            <label for="name">Name :</label>
            <input type="text" id="price" name="price" v-model="name" required />
            <label for="price">Price :</label>
            <input type="text" id="price" name="price" v-model="price" required />
            <label for="description">Description :</label>
            <input id="description" name="description" v-model="description" />
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
                <tr v-for="item in products" :key="item.id" class="active-row">
                    <td>{{ item.name }}</td>
                    <td>{{ item.price }} Ar</td>
                    <td>{{ item.description }}</td>
                    <td>
                        <form @submit.prevent="formUpdate(item.id, item.name, item.price, item.description)">
                            <button>Editer</button>
                        </form>
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
import { defineComponent, ref } from "vue";
import {
    getProduct,
    createProduct,
    deleteProduct,
} from "@/services/productService.api";
export default defineComponent({
    data() {
        return {
            name: null,
            price: null,
            description: null,
            products: null,

        };
    },
    async created() {
        try {
            const result = await getProduct();
            this.products = result?.data;
            console.log(this.products);
        } catch (error) {
            console.log(error);
        }
    },
    methods: {
        async formCreation() {
            console.log(this.name);
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
        },
        formUpdate(id: string, name: string, price: string, description: string) {
            console.log(id)
            window.location.href = "/updateproduct/"+id+"/"+name+"/"+price+"/"+description;
        }
    },
});
</script>
<style>
.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}

.styled-table th,
.styled-table td {
    padding: 12px 15px;
}

.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}
</style>
