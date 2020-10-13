<template>
  <div>
    <div class="logo"/>
    <a-menu theme="dark" :default-selected-keys="['1']" mode="inline">
      <a-menu-item key="1">
        <a-icon type="pie-chart"/>
        <span> <router-link to="/editNotice">发布公告</router-link></span>
      </a-menu-item>
      <a-menu-item key="2">
        <a-icon type="desktop"/>
        <span>
          <router-link to="/editNews">发布新闻</router-link>
        </span>
      </a-menu-item>
      <a-sub-menu key="sub1">
        <span slot="title"><a-icon type="user"/><span>浏览 </span></span>
        <a-menu-item key="3">
          <router-link :to="{
            path: '/browseNotice',
            query: {
              name: 'notice'
            }
          }">浏览公告</router-link>
        </a-menu-item>
        <a-menu-item key="4">
          <router-link :to="{
            path: '/browseNews',
            query: {
              name: 'news'
            }
          }">浏览新闻</router-link>
        </a-menu-item>
        <a-menu-item key="5">
          <router-link  :to="{
            path: '/browseComment',
            query: {
              name: 'comment'
            }
          }" >浏览评论</router-link>
        </a-menu-item>
      </a-sub-menu>
      <a-sub-menu key="sub2">
        <span slot="title"><a-icon type="team"/><span><a href="/compose?ds=xx">用户管理</a></span></span>
        <a-menu-item key="6">
          <router-link to="/browseComment"> 会员</router-link>
        </a-menu-item>
        <a-menu-item key="8">
          游客
        </a-menu-item>
      </a-sub-menu>
      <a-menu-item key="9">
        <a-icon type="file"/>
        <span>File</span>
      </a-menu-item>
    </a-menu>
  </div>
</template>

<script>
import { EventBus } from '../tableList/operation/event-bus'
console.log(EventBus)
export default {
  name: 'Lateral',
  data: function () {
    return {
      id: '1',
      id2: '2',
      id3: '3'
    }
  },
  methods: {
    additionHandle () {
      EventBus.$emit('addition', {
        num: this.num++
      })
    }
  }
}

</script>

<style scoped>

</style>
