import Vue from 'vue'
import Meta from 'vue-meta'
import App from './history.vue'

import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'

import axios from 'axios'
Vue.prototype.$axios = axios
Vue.use(Antd)
Vue.use(Meta)

new Vue({
  render: h => h(App)
}).$mount('#app')
//
// const app = new Vue({
//   render: createElement => createElement(App)
// }).$mount('#app')
