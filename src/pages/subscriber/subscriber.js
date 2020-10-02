import Vue from 'vue'
import Meta from 'vue-meta'
import subscriber from './subscriber.vue'
Vue.use(Meta)

const app = new Vue({
  ...subscriber
})

app.$mount('#app')
