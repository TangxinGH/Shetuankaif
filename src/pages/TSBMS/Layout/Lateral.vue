<template>
  <div>
    <div ><img width="200" src="../../../assets/img/avstar.jpg"></div>
    <a-menu theme="light" mode="inline">
      <a-menu-item key="1" >
        <a-icon type="pie-chart"/>
        <span> <router-link to="/editNews"> 发布公告</router-link></span>
      </a-menu-item>
      <a-menu-item key="2">
        <a-icon type="desktop"/>
        <span>
          <router-link to="/editNotice">发布新闻</router-link>
        </span>
      </a-menu-item>
      <a-sub-menu key="sub1">
        <span slot="title"><a-icon type="user"/><span>浏览 </span></span>
        <a-menu-item key="3" @click="changeBrowseHandle('browseNotice')">浏览公告        </a-menu-item>
        <a-menu-item key="4" @click="changeBrowseHandle('browseNews')">浏览活动</a-menu-item>
        <a-menu-item key="5" @click="changeBrowseHandle('browseComment')"> 浏览评论        </a-menu-item>
      </a-sub-menu>
      <a-sub-menu key="sub2">
        <span slot="title"><a-icon type="team"/><span>用户管理</span></span>
        <a-menu-item key="6">
          <router-link to="/MangeUserVIP"> 管理员</router-link>
        </a-menu-item>
        <a-menu-item key="8">
          <router-link to="/MangeUser">   会员 </router-link>
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
    changeBrowseHandle (toCommon) {
      this.$router.push({ path: toCommon }).catch(err => {
        // Ignore the vuex err regarding  navigating to the page they are already on.
        if (
          err.name !== toCommon &&
            !err.message.includes('Avoided redundant navigation to current location')
        ) {
          // But print any other errors to the console
          console.log(err)
        }
      })

      EventBus.$emit(toCommon, {
        to: toCommon
      })
    }
  }
}

</script>

<style scoped>

</style>
