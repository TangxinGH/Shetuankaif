
import Vue from 'vue'
import Meta from 'vue-meta'
import App from './article.vue'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'

import axios from 'axios'

Vue.use(Antd)
Vue.use(Meta)
Vue.prototype.$axios = axios

const app = new Vue({
  ...App
})

app.$mount('#app')
