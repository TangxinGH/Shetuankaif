<template>
  <!-- Material form login -->
  <form >
    <p class="h4 text-center mb-4">Sign in</p>
    <div class="grey-text">
      <mdb-input label="帐号" icon="envelope"  v-model="admin" />
      <mdb-input label="密码" icon="lock" type="password" v-model="adminPass" />
    </div>
    <div class="text-center">
      <mdb-btn @click="onSubmit">Login</mdb-btn>
    </div>
  </form>
  <!-- Material form login -->
</template>
<script>
import { mdbInput, mdbBtn } from 'mdbvue'
require('bootstrap-css-only/css/bootstrap.min.css')
require('mdbvue/lib/css/mdb.min.css')
require('@fortawesome/fontawesome-free/css/all.min.css')
export default {
  name: 'administrator',
  components: {
    mdbInput,
    mdbBtn
  },
  data: function () {
    return {
      env: process.env.NODE_ENV === 'production',
      admin: '',
      adminPass: ''
    }
  },
  methods: {
    onSubmit () {
      const regP = /^[\w_-]{3,10}$/
      const regS = /^\d{3,11}$/
      if (!regS.test(this.admin)) { this.$message.warn('帐号3 到11 位数字'); return }
      if (!regP.test(this.adminPass)) { this.$message.warn('密码 格式不对 3-10位 可以包含小写大母和大写字母数字下划线和减号'); return }
      if (this.admin != '' && this.adminPass != '') { window.open(this.env ? '/tsbms.html' : '/tsbms', '_blank') } else this.$message.warn('请输入帐号或者密码')
      localStorage.admin = this.admin
    }
  }
}
</script>
