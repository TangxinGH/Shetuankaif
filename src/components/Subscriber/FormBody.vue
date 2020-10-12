<template>
    <div class="content shadow" v-bind:class="{ 's--signup': isActive}">
      <form  @submit="checkSignInForm">
      <div class="form sign-in">
        <h2>欢迎回来</h2>
        <label>
          <span>学号 {{sno}}</span>
          <input type="text" v-model="sno" v-bind:pattern="sno_pattern" v-bind:title="sno_title" required/>
        </label>
        <label>
          <span>密码{{password}}</span>
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
        <form  @submit="checkSignUpForm">
        <div class="form sign-up">
          <h2>立即注册</h2>
          <label>
            <span>学号</span>
            <input type="text" v-model="sign_up_sno" v-bind:pattern="sno_pattern" v-bind:title="sno_title" required />
          </label>
          <label>
            <span>昵称</span>
            <input type="text" v-model="sign_up_name"
                  v-bind:pattern="username_pattern"
                   v-bind:title="username_title "/>
          </label>
          <label>
            <span>密码</span>
            <input type="password" v-model="sign_up_password" v-bind:pattern="pass_pattern"  v-bind:title="pass_title" required/>
<!--             aria-required属性经常在提供之前表明用户输入是必须的。aria-required属性有true和false两个值。
例如，如果用户必须输入地址区域，将aria-required设置为true。
注1： 当星号和其他文本符号编程式与区域联系，-->
          </label>
          <button type="submit" class="submit">注 册</button>
            <button type="button" class="fb-btn">使用 <span>QQ</span> 帐号注册</button>
        </div>
        </form>
      </div>
<!--      <p v-if="errors.length">-->
<!--        <b>Please correct the following error(s): </b>-->
<!--       <ul>-->
<!--         <li v-for="error in errors"> {{ error }} </li>-->
<!--        </ul>-->
<!--      </p>-->

    </div>
</template>

<script>
export default {
  name: 'FromBody',
  data: function () {
    return {
      isActive: true,
      /* validate */
      pass_pattern: '^[\\w_-]{3,10}$',
      pass_title: '3-10位 可以包含小写大母和大写字母数字下划线和减号',
      sno_pattern: '^\\d{3,11}$',
      sno_title: '3 到11位数',
      username_pattern: '^[a-zA-Z\u4E00-\u9FA5][a-zA-Z0-9\u4E00-\u9FA5_-]{3,10}',
      username_title: '3 到10字符  首字母只能是大小写字母 小大写 数字 下划线  允许中文',

      /* // 数据与v-model 绑定 */
      sno: '',
      password: '',
      /* 注册 */
      sign_up_sno: '',
      sign_up_password: '',
      sign_up_name: '',
      mounted: function () {
      }
    }
  },
  methods: {
    checkSignInForm: function (e) {

      // e.preventDefault() 这是什么？
    },
    checkSignUpForm: function (e) {

    },
    validEmail (email) {
      return false
    }
  }
}
</script>

<style scoped>
.shadow{
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
  margin: 25px auto 0;
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
