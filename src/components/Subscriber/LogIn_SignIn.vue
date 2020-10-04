<template>
  <div>
    <div class="nav">
      <ul class="sidenav">
        <li><a class="active" href="#home">主页</a></li>
        <li><a href="#news">新闻</a></li>
        <li><a href="#contact">联系</a></li>
        <li style="float: right;margin-right: 10vw"><a href="#about">关于</a></li>
      </ul>
    </div>
    <circle-a-p-ps/>
    <FromBody></FromBody>
  </div>
</template>

<script>
import CircleAPPs from '@/components/Subscriber/circleAPPs'
import FromBody from '@/components/Subscriber/FormBody'

export default {
  name: 'LogIn_SignIn',
  components: { FromBody, CircleAPPs },

}
</script>

<style lang="less" scoped>
.nav {
  ul.sidenav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 25%;
    background-color: #f1f1f1;
    height: 100%;
    overflow: auto;
  }

  ul.sidenav li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
  }

  ul.sidenav li a.active {
    background-color: #4CAF50;
    color: white;
  }

  ul.sidenav li a:hover:not(.active) {
    background-color: #555;
    color: white;
  }

  ul.sidenav {
    width: 100%;
    height: auto;
  }

  ul.sidenav li a {
    float: left;
    padding: 15px;
  }
}
</style>
