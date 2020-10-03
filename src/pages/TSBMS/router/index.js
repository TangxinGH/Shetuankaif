import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../../../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/editNotice',
    // redirect: '/tsbms/test',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (author.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "author" */ '../../../views/About.vue')
  },
  {
    path: 'tsbmstest',
    name: 'tsbmstes'
  }
]

const router = new VueRouter({
  mode: 'hash',
  // base: process.env.BASE_URL,
  base: process.env.NODE_ENV === 'production' ? '/tsbms.html' : '/tsbms',
  routes
})

export default router
