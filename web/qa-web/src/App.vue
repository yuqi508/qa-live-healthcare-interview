<script setup lang="ts">
import { RouterView } from 'vue-router';
import AppHeader from './components/AppHeader.vue';
import AppFooter from './components/AppFooter.vue';
import { computed } from 'vue'
import { useI18n } from 'vue-i18n'

const { locale } = useI18n()
const localew = computed(() => locale.value)

</script>

<template>
  <a-layout class="app-layout">
<!--    <a-config-provider :locale="localew">-->
    <AppHeader />
    <a-layout-content class="app-content">
      <RouterView />
    </a-layout-content>
    <AppFooter />
<!--    </a-config-provider>-->
  </a-layout>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.app-layout {
  min-height: 100vh;
}

.app-content {
  background: #fff;
}
</style>
