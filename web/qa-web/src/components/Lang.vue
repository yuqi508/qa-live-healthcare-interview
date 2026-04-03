<template>
  <a-button @click="changeLanguage">{{ langName }}</a-button>
</template>

<script setup lang="ts">
import { useI18n } from 'vue-i18n'
import { onMounted, reactive, toRefs } from "vue";

const { locale } = useI18n()


const state = reactive({
  langName: '简体中文',
})
const { langName } = toRefs(state);


const changeLanguage = () => {

  if (locale.value === 'en') {
    locale.value = 'zh'
    state.langName = '简体中文'
  } else {
    locale.value = 'en'
    state.langName = 'English'

  }
  // locale.value = locale.value === 'en' ? 'zh' : 'en';
  // // 刷新页面
  // window.location.reload()
}
onMounted(async()=>{
  changeLanguage()
})


</script>
