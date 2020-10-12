import Vue from 'vue'
import Meta from 'vue-meta'
import subscriber from './subscriber.vue'

// import Antd from 'ant-design-vue'
// import 'ant-design-vue/dist/antd.css'

Vue.use(Meta)

// Vue.use(Antd)

new Vue({
  render: h => h(subscriber)
}).$mount('#app')
