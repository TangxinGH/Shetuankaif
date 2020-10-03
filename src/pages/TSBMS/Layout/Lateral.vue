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
        <span slot="title"><a-icon type="user"/><span>
          <router-link to="/browseArticle">浏览文章</router-link>
          </span></span>
        <a-menu-item key="3">
          Tom
        </a-menu-item>
        <a-menu-item key="4">
          Bill
        </a-menu-item>
        <a-menu-item key="5">
          Alex
        </a-menu-item>
      </a-sub-menu>
      <a-sub-menu key="sub2">
        <span slot="title"><a-icon type="team"/><span><a href="/compose?ds=xx">用户管理</a></span></span>
        <a-menu-item key="6">
          Team 1
        </a-menu-item>
        <a-menu-item key="8">
          Team 2
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
export default {
  name: 'Lateral'
}
</script>

<style scoped>

</style>
