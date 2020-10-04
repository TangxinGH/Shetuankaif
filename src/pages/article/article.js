
import Vue from 'vue'
import Meta from 'vue-meta'
import App from './article.vue'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'

Vue.use(Antd)
Vue.use(Meta)

const app = new Vue({
  ...App
})

app.$mount('#app')
