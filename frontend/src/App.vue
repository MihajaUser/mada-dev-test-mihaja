<template>
  <ListeProduit />
</template>
<script lang="ts">
import { defineComponent } from 'vue';
import ListeProduit from './components/ListeProduit.vue';

export default defineComponent({
  name: 'App',
  components: { ListeProduit }
});
</script>

<style></style>
