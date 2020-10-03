import Vue from 'vue'
import Meta from 'vue-meta'
import TSBMS from './TSBMS.vue'
import router from './router'

import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
Vue.use(Antd)
Vue.use(Meta)

const app = new Vue({
  ...TSBMS,
  router
})

app.$mount('#app')
