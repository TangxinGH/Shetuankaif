<template>
  <div>
  <div class="logoheader"/>
  <a-menu
      theme="dark"
      mode="horizontal"
      :style="{ lineHeight: '64px'  }"
  >
    <a-menu-item key="1">
       <a href="/sichuan.html"> 首页</a>
    </a-menu-item>
    <a-menu-item key="2">
      <a> 个人信息</a>
    </a-menu-item>
    <a-menu-item key="3">
      <a>登出</a>
    </a-menu-item>
  </a-menu>
  </div>
</template>

<script>
export default {
  name: 'Apex'
}
</script>

<style scoped>

</style>
