import Vue from 'vue'
import Meta from 'vue-meta'
import App from './Sichuan.vue'
import sichuanMenu from './module/sichuanMenu'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import sichuanContent from '@/pages/Sichuan/module/sichuanContent'
import axios from 'axios'
Vue.prototype.$axios = axios
Vue.use(Antd)
Vue.use(Meta)

const app = new Vue({
  render: h => h(App)
}).$mount('#app')

/* 多个实例 */
const siMenu = new Vue({
  render: h => h(sichuanMenu)
}).$mount('#sichuanMenu')

const siContent = new Vue({
  render: h => h(sichuanContent)
}).$mount('#sichuanContent')
