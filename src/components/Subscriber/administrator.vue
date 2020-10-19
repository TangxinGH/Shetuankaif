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
      const regS = /^\d{3,13}$/
      if (!regS.test(this.admin)) { this.$message.warn('帐号3 到13 位数字'); return }
      if (!regP.test(this.adminPass)) { this.$message.warn('密码 格式不对 3-10位 可以包含小写大母和大写字母数字下划线和减号'); return }
      if (this.admin != '' && this.adminPass != '') {
        this.loginadmin()
      } else this.$message.warn('请输入帐号或者密码')
    },
    loginadmin: function () {
      let config = {
        params: {
          adNo: this.admin,
          adPassword: this.adminPass

        }
      }
      this.$axios.post('api/loginAdmin', null, config).then(res => {
        let code = res.code
        if (code != null) {
          switch (parseInt(res.code.code)) {
            case 20:
              console.log('成功')
              this.$message.success('登录成功')
              // localStorage 对象存储的数据没有时间限制。第二天、第二周或下一年之后，数据依然可用。
              localStorage.setItem('admin', JSON.stringify(res.admin)) // 存储
              localStorage.setItem('sname', res.admin.adName)
              window.open(this.env ? '/tsbms.html' : '/tsbms')

              break
            case 1000:
              console.log('用户不存在')
              this.$message.error('用户不存在')
              break
            case 1001:
              console.log('密码错误')
              this.$message.error('密码错误')
              break
            default:
              console.log('未知错误')
              this.$message.error('未知错误')
              break
          }
        } else this.$message.error('返回空')
      }).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>
