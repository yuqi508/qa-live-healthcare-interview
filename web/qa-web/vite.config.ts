import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  base: '/',
  resolve: {
    // 配置别名
    alias: {
      '@': resolve(__dirname, './src'),
      'vue-i18n': 'vue-i18n/dist/vue-i18n.cjs.js'
    }
  },
  plugins: [vue()],
  //启动服务配置
  server: {
    // 服务器主机名，如果允许外部访问，可设置为 "0.0.0.0" 也可设置成你的ip地址
    host: '0.0.0.0',
    port: 8080,
    open: true,
    https: false,
    cors: true,
    // 代理跨域（模拟示例）
    proxy: {
      "/qa-user": {
        target: "http://localhost:8081", // easymock
        changeOrigin: true,
        rewrite: path => path.replace(/^\/qa-user/, "")
      }
    },
  },
})
