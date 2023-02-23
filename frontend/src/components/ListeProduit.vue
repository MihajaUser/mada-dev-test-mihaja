<template>
    <div class="app">
        {{ product }}
        <h1>CRUD Interface</h1>
        <form>
            <h2>Créer une nouvelle entrée</h2>
            <label for="name">Name :</label>
            <input type="text" id="price" name="price" required>

            <label for="price">Price :</label>
            <input type="text" id="price" name="price" required>

            <label for="description">Description :</label>
            <textarea id="description" name="description"></textarea>
            <button type="submit">Créer</button>
        </form>

        <h2>Liste des produits</h2>
        <table>
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Nom de l'entrée</td>
                    <td>Description de l'entrée</td>
                    <td>
                        <button>Editer</button>
                        <button>Supprimer</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script lang="ts">

import { defineComponent, ref } from 'vue';
import { getProduct } from '@/service/productService.api';
export default defineComponent({
    data() {
        return {
            product: null,
        }
    },
    async created() {
        try {
            const result = await await getProduct();
            this.product = result?.data
        } catch (error) {
            console.log(error);
        }
    },
    methods: {
        myMessage() {
            console.log("my message mihaja")
            // return "my message";
        }
    }

});


</script>