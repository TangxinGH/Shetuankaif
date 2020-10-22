<template>
  <div class="content shadow" v-bind:class="{ 's--signup': isActive}">
    <form @submit="checkSignInForm">
      <div class="form sign-in">
        <h2>欢迎回来</h2>
        <label>
          <span>学号 {{ !env ? sno : '' }}</span>
          <input type="text" v-model="sno" v-bind:pattern="sno_pattern" v-bind:title="sno_title" required/>
        </label>
        <label>
          <span>密码{{ !env ? password : ''   }}</span>
          <input type="password" v-model="password" v-bind:pattern="pass_pattern" v-bind:title="pass_title" required/>
        </label>
        <p class="forgot-pass"><a href="javascript:">忘记密码？</a></p>
        <button type="submit" class="submit">登 录</button>
        <button type="button" class="fb-btn">使用 <span>QQ</span> 帐号登录</button>
      </div>
    </form>
    <div class="sub-cont">
      <div class="img">
        <div class="img__text m--up">
          <h2>还未注册？</h2>
          <p>立即注册，发现大量机会！</p>
        </div>
        <div class="img__text m--in">
          <h2>已有帐号？</h2>
          <p>有帐号就登录吧，好久不见了！</p>
        </div>
        <div class="img__btn" v-on:click="isActive=!isActive">
          <span class="m--up">注 册</span>
          <span class="m--in">登 录</span>
        </div>
      </div>
      <form @submit="checkSignUpForm">
        <div class="form sign-up">
          <h2>立即注册</h2>
          <label>
            <span>学号</span>
            <input type="text" v-model="sign_up_sno" v-bind:pattern="sno_pattern" v-bind:title="sno_title" required/>
          </label>
          <label>
            <span>姓名</span>
            <input type="text" v-model="sign_up_name"
                   v-bind:pattern="username_pattern"
                   v-bind:title="username_title "/>
          </label>
          <label>
            <span>密码</span>
            <input type="password" v-model="sign_up_password" v-bind:pattern="pass_pattern" v-bind:title="pass_title"
                   required/>
          </label>
          <label>
            <span>确认密码</span>
            <input type="password" v-model="sign_up_password_confirm" v-bind:pattern="pass_pattern"
                   v-bind:title="pass_title"
                   required/>
          </label>
          <button type="submit" class="submit">注 册</button>
          <button type="button" class="fb-btn">使用 <span>QQ</span> 帐号注册</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import qs from 'qs'

export default {
  name: 'FromBody',
  data: function () {
    return {
      isActive: true,
      /* validate */
      pass_pattern: '^[\\w_-]{3,10}$',
      pass_title: '3-10位 可以包含小写大母和大写字母数字下划线和减号',
      sno_pattern: '^\\d{3,15}$',
      sno_title: '3 到15位数字',
      username_pattern: '^[a-zA-Z\u4E00-\u9FA5][a-zA-Z0-9\u4E00-\u9FA5_-]{3,10}',
      username_title: '3 到10字符  首字母只能是大小写字母 小大写 数字 下划线  允许中文',
      errors: false,
      /* // 数据与v-model 绑定 */
      sno: '',
      password: '',
      /* 注册 */
      sign_up_sno: '',
      sign_up_password: '',
      sign_up_password_confirm: '',
      sign_up_name: '',

      env: process.env.NODE_ENV === 'production'
    }
  },
  methods: {
    checkSignInForm: async function (e) {
      e.preventDefault() // 这是什么？ 方法将取消事件（如果可取消）
      // 检查登录
      // const options = {
      //   method: 'POST',
      //   headers: { 'content-type': 'application/x-www-form-urlencoded' },
      //   data: qs.stringify({ Sno: this.sno, Password: this.password }),
      //   url: '/api/login'
      // }
      // this.$axios(options)
      let that = this/* 这是一个this指向问题,this始终指向Vue,所以需要将this保存在that中,在使用其他操作的时候可以用that代替。不然下面的$Message未定义！！！what */
      await this.$axios.post('/api/login',
        null,
        {
          params: {
            Sno: this.sno,
            Password: this.password
          }
        }
        // qs 会转换为 pplication/x-www-form-urlencoded https://github.com/axios/axios#interceptors
      ).then(function (response) {
        window.console.log('login post' + response)
        let code = response.code
        if (code != null) {
          switch (parseInt(response.code.code)) {
            case 20:
              console.log('成功')
              that.$message.success('登录成功')
              // localStorage 对象存储的数据没有时间限制。第二天、第二周或下一年之后，数据依然可用。
              localStorage.setItem('Sno', that.sno) // 存储
              localStorage.setItem('user', JSON.stringify(response.user))
              localStorage.setItem('sname', response.user.sname)
              that.$router.push({ path: './browseInfo' })
              break
            case 21:
              console.log('用户不存在')
              that.$message.error('用户不存在')
              break
            case 22:
              console.log('密码错误')
              that.$message.error('密码错误')
              break
            default:
              console.log('未知错误')
              that.$message.error('未知错误')
              break
          }
        } else {
          that.$message.error('返回空')
        }
      }).catch(error =>
        console.log(error))
    },
    checkSignUpForm: async function (e) {
      e.preventDefault()
      if (this.sign_up_password !== this.sign_up_password_confirm) {
        this.$message.error('两次密码不一致')
        return
      }
      let that = this
      await this.$axios.post('/api/register',
        {
          sno: this.sign_up_sno,
          password: this.sign_up_password,
          sname: this.sign_up_name,
          scollege: '桂林理工大学',
          sex: '男',
          age: 18,
          joined: false
        }
        // qs 会转换为 pplication/x-www-form-urlencoded https://github.com/axios/axios#interceptors
      ).then(function (response) {
        window.console.log('register post' + response)
        let code = response.code
        if (code != null) {
          switch (parseInt(response.code)) {
            case 30:
              console.log('成功')
              that.$message.success('注册成功')
              that.isActive = false
              break
            case 31:
              console.log('用户已存在')
              that.$message.error('用户已存在')
              break
            case 32:
              console.log('用户格式不对')
              that.$message.error('用户格式不对')
              break
            default:
              console.log('密码格式不对或者')
              that.$message.error('密码格式不对或者')
              break
          }
        } else {
          that.$message.error('返回空')
        }
      }).catch(error =>
        console.log(error))
    },
    validEmail (email) {
      return false
    }
  }
}
</script>

<style scoped>
.shadow {
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3); /*阴影*/
}

*, *:before, *:after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Open Sans', Helvetica, Arial, sans-serif;
  background: #ededed;
}

input, button {
  border: none;
  outline: none;
  background: none;
  font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}

.tip {
  font-size: 20px;
  margin: 40px auto 50px;
  text-align: center;
}

.content {
  overflow: hidden;
  position: absolute;
  left: 50%;
  top: 50%;
  width: 900px;
  height: 550px;
  margin: 10vh 0 0 -250px;
  background: #fff;
}

.form {
  position: relative;
  width: 640px;
  height: 100%;
  transition: -webkit-transform 0.6s ease-in-out;
  transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
  padding: 50px 30px 0;
}

.sub-cont {
  overflow: hidden;
  position: absolute;
  left: 640px;
  top: 0;
  width: 900px;
  height: 100%;
  padding-left: 260px;
  background: #fff;
  transition: -webkit-transform 0.6s ease-in-out;
  transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
}

.content.s--signup .sub-cont {
  -webkit-transform: translate3d(-640px, 0, 0);
  transform: translate3d(-640px, 0, 0);
}

button {
  display: block;
  margin: 0 auto;
  width: 260px;
  height: 36px;
  border-radius: 30px;
  color: #fff;
  font-size: 15px;
  cursor: pointer;
}

.img {
  overflow: hidden;
  z-index: 2;
  position: absolute;
  left: 0;
  top: 0;
  width: 260px;
  height: 100%;
  padding-top: 360px;
}

.img:before {
  content: '';
  position: absolute;
  right: 0;
  top: 0;
  width: 900px;
  height: 100%;
  background-image: url(../../assets/img/bg.jpg);
  background-size: cover;
  transition: -webkit-transform 0.6s ease-in-out;
  transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
}

.img:after {
  content: '';
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.6);
}

.content.s--signup .img:before {
  -webkit-transform: translate3d(640px, 0, 0);
  transform: translate3d(640px, 0, 0);
}

.img__text {
  z-index: 2;
  position: absolute;
  left: 0;
  top: 50px;
  width: 100%;
  padding: 0 20px;
  text-align: center;
  color: #fff;
  transition: -webkit-transform 0.6s ease-in-out;
  transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
}

.img__text h2 {
  margin-bottom: 10px;
  font-weight: normal;
}

.img__text p {
  font-size: 14px;
  line-height: 1.5;
}

.content.s--signup .img__text.m--up {
  -webkit-transform: translateX(520px);
  transform: translateX(520px);
}

.img__text.m--in {
  -webkit-transform: translateX(-520px);
  transform: translateX(-520px);
}

.content.s--signup .img__text.m--in {
  -webkit-transform: translateX(0);
  transform: translateX(0);
}

.img__btn {
  overflow: hidden;
  z-index: 2;
  position: relative;
  width: 100px;
  height: 36px;
  margin: 0 auto;
  background: transparent;
  color: #fff;
  text-transform: uppercase;
  font-size: 15px;
  cursor: pointer;
}

.img__btn:after {
  content: '';
  z-index: 2;
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  border: 2px solid #fff;
  border-radius: 30px;
}

.img__btn span {
  position: absolute;
  left: 0;
  top: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  transition: -webkit-transform 0.6s;
  transition: transform 0.6s;
  transition: transform 0.6s, -webkit-transform 0.6s;
}

.img__btn span.m--in {
  -webkit-transform: translateY(-72px);
  transform: translateY(-72px);
}

.content.s--signup .img__btn span.m--in {
  -webkit-transform: translateY(0);
  transform: translateY(0);
}

.content.s--signup .img__btn span.m--up {
  -webkit-transform: translateY(72px);
  transform: translateY(72px);
}

h2 {
  width: 100%;
  font-size: 26px;
  text-align: center;
}

label {
  display: block;
  width: 260px;
  margin: 10px auto 0;
  text-align: center;
}

label span {
  font-size: 12px;
  color: #909399;
  text-transform: uppercase;
}

input {
  display: block;
  width: 100%;
  margin-top: 5px;
  padding-bottom: 5px;
  font-size: 16px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.4);
  text-align: center;
}

.forgot-pass {
  margin-top: 15px;
  text-align: center;
  font-size: 12px;
  color: #cfcfcf;
}

.forgot-pass a {
  color: #cfcfcf;
}

.submit {
  margin-top: 40px;
  margin-bottom: 20px;
  background: #d4af7a;
  text-transform: uppercase;
}

.fb-btn {
  border: 2px solid #d3dae9;
  color: #8fa1c7;
}

.fb-btn span {
  font-weight: bold;
  color: #455a81;
}

.sign-in {
  transition-timing-function: ease-out;
}

.content.s--signup .sign-in {
  transition-timing-function: ease-in-out;
  transition-duration: 0.6s;
  -webkit-transform: translate3d(640px, 0, 0);
  transform: translate3d(640px, 0, 0);
}

.sign-up {
  -webkit-transform: translate3d(-900px, 0, 0);
  transform: translate3d(-900px, 0, 0);
}

.content.s--signup .sign-up {
  -webkit-transform: translate3d(0, 0, 0);
  transform: translate3d(0, 0, 0);
}
</style>
