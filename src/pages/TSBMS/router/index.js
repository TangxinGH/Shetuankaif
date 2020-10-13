import Vue from 'vue'
import VueRouter from 'vue-router'
import common from '@/pages/TSBMS/tableList/common'
import users from '@/views/users'
import MVPUsers from '@/views/MVPUsers'
Vue.use(VueRouter)

const routes = [
  {
    path: '/browseNotice',
    // redirect: '/tsbms/test',
    name: 'browseNotice',
    component: common
  },
  {
    path: '/browseNews',
    name: 'browseNews',
    // route level code-splitting
    // this generates a separate chunk (author.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "author" */ '../tableList/common')
  },
  {
    path: '/browseComment',
    name: 'browseComment',
    component: common
  },
  {
    path: '/MangeUser',
    name: 'MangeUser',
    component: users
  },
  {
    path: '/MangeUserVIP',
    name: 'MangeUserVIP',
    component: MVPUsers
  }
]

const router = new VueRouter({
  mode: 'hash',
  // base: process.env.BASE_URL,
  base: process.env.NODE_ENV === 'production' ? '/tsbms.html' : '/tsbms',
  routes
})

export default router
