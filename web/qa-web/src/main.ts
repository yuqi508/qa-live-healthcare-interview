import { createApp } from 'vue';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
import './style.css';
import App from './App.vue';
import router from './router';
import { createPinia } from 'pinia'

//maolu add
import { createI18n } from 'vue-i18n';
import en from './locales/en.ts';
import zh from './locales/zh.ts';
const i18n = createI18n({
    locale: 'en', // 设置默认语言
    messages: {
        en,
        zh,
    },
});


const app = createApp(App);
app.use(i18n); // 使用 i18n 插件
app.use(Antd);
app.use(router);
app.use(createPinia())
app.mount('#app');
