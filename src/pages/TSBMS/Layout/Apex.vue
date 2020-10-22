<template>
  <div>
  <div class="logoheader"/>
  <a-menu
      theme="dark"
      mode="horizontal"
      :style="{ lineHeight: '64px'  }"
  >
    <a-menu-item key="1">
       <a href="/index.html"> 首页</a>
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
        <p>学号: {{ adminSno }}</p>
        <p>姓名: {{ adminName}} </p>
      </a-modal>
    </a-menu-item>
    <a-menu-item key="3">
      <span @click="logOut" >登出</span>
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
      confirmLoading: false,
      adminSno: '',
      adminName: ''
    }
  },
  mounted () {
    this.adminName = localStorage.getItem('sname')
    this.adminSno = JSON.parse(localStorage.getItem('admin')).sno
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
    },
    logOut: function () {
      this.$message.warn('2s后清除所有数据')
      setTimeout(function () { window.open('/index.html') }, 2000)
      localStorage.clear()// 清除所有
    }
  }
}
</script>

<style scoped>

</style>
