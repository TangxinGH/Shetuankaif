<template>
  <div>
  <div class="logoheader"/>
  <a-menu
      theme="dark"
      mode="horizontal"
      :default-selected-keys="['2']"
      :style="{ lineHeight: '64px'  }"
  >
    <a-menu-item key="1">
      导航 1
    </a-menu-item>
    <a-menu-item key="2">
      导航 2
    </a-menu-item>
    <a-menu-item key="3">
      导航 3
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
