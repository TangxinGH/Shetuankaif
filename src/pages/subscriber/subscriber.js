import Vue from 'vue'
import Meta from 'vue-meta'
import subscriber from './subscriber.vue'
import axios from '../../utils/axios' // 全局注册，使用方法为:this.$axios
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import router from './subrouter'
Vue.use(Antd)
// import Mock from './mock.js' // 自定义
Vue.prototype.$axios = axios
// Vue.use(Mock)
Vue.use(Meta)

new Vue({
  render: h => h(subscriber),
  router
}).$mount('#app')
