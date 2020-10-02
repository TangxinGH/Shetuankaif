
import Vue from 'vue'
import Meta from 'vue-meta'
import App from './article.vue'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

// import Antd from 'ant-design-vue'
// import 'ant-design-vue/dist/antd.css'
//
// Vue.use(Antd)
Vue.use(Meta)

const app = new Vue({
  ...App
})

app.$mount('#app')
