import Vue from 'vue'
import Meta from 'vue-meta'
import TSBMS from './TSBMS.vue'
import router from './router'

import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import axios from 'axios'
import Vuex from 'vuex'
Vue.use(Antd)
Vue.use(Meta)

Vue.use(Vuex)
Vue.prototype.$axios = axios
const app = new Vue({
  ...TSBMS,
  router
})

app.$mount('#app')
