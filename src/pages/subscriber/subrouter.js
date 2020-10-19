import Vue from 'vue'
import VueRouter from 'vue-router'
import FormBody from '@/components/Subscriber/FormBody'
import Home from '@/views/Home'
Vue.use(VueRouter)

const routes = [
  {
    path: '/browseInfo',
    // redirect: '/tsbms/test',
    name: '/browseInfo',
    component: Home
  },
  {
    path: '/',
    name: 'formbody',
    component: FormBody
  }
]

const router = new VueRouter({
  mode: 'hash',
  // base: process.env.BASE_URL,
  base: process.env.NODE_ENV === 'production' ? '/subscriber.html' : '/subscriber',
  routes
})

export default router
