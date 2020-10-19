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
      <a @click="showModal"> 个人信息</a>
      <a-modal
          title="个人信息"
          :visible="visible"
          :confirm-loading="confirmLoading"
          @ok="handleOk"
          @cancel="handleCancel"
      >
        <p>学号: 4445454454</p>
        <p>姓名: 在在是 </p>
      </a-modal>
    </a-menu-item>
    <a-menu-item key="3">
      <a>登出</a>
    </a-menu-item>
  </a-menu>
  </div>
</template>

<script>
export default {
  name: 'Apex',
  data () {
    return {
      visible: false,
      confirmLoading: false
    }
  },
  mounted () {
    this.$axios.get('api/getAdmins')
  },
  methods: {
    showModal () {
      this.visible = true
    },
    handleOk (e) {
      this.confirmLoading = true
      setTimeout(() => {
        this.visible = false
        this.confirmLoading = false
      }, 2000)
    },
    handleCancel (e) {
      this.visible = false
    }
  }
}
</script>

<style scoped>

</style>
