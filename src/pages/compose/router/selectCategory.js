import Vue from 'vue'
import VueRouter from 'vue-router'

import editNews from '@/pages/compose/category/editNews'
import editNotice from '@/pages/compose/category/editNotice'
const originalPush = VueRouter.prototype.push

VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err) // 错误抑制  ？？？ 不太好 吧？
}
Vue.use(VueRouter)

const routes = [
  {
    path: '/editNews',
    // redirect: '/tsbms/test',
    name: 'editNews',
    component: editNews
  },
  {
    path: '/markdown',
    name: 'Markdown',
    // route level code-splitting
    // this generates a separate chunk (author.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "author" */ '../../../components/Markdown/index')
  },
  {
    path: '/editNotice',
    name: 'editNotice',
    component: editNotice
  }
]

const router = new VueRouter({
  mode: 'hash',
  // base: process.env.BASE_URL,
  base: process.env.NODE_ENV === 'production' ? '/tsbms.html' : '/tsbms',
  routes
})

export default router
