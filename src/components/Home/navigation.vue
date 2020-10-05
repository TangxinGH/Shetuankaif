<template>
    <div>
      <div class="header">
        <a href="#default" class="logo"> KUNPENGSHETAUN
<!--          <img style="height: 50px" src="../../assets/img/kunpeng.jpg">-->
        </a>
        <div class="header-right">
          <a class="active"  v-bind:href="env? './index.html' : './index'"><i></i>首页</a>
          <a v-bind:href="env ? './article.html' : './article'"><i></i>文章页</a>
          <a v-bind:href="env ? './compose.html' : './compose'"><i></i>编辑文章</a>
          <a v-bind:href="env ? './subscriber.html' : './subscriber'"><i></i>subscriber登录</a>
          <a v-bind:href="env ? './tsbms.html' : './tsbms'"><i></i>后台管理</a>
        </div>
      </div>
    </div>
</template>

<script>
// Element 额外提供了一系列类名，用于在某些条件下隐藏元素。
// 这些类名可以添加在任何 DOM 元素或自定义组件上。
// 如果需要，请自行引入以下文件：
import 'element-ui/lib/theme-chalk/display.css'

export default {
  name: 'navigation',
  data: function () {
    return {
      env: process.env.NODE_ENV === 'production' // I think that you should avoid using process directly in template and you can use computed for proxying.
    }
  }
}
</script>

<style scoped>

a{font-family:"Times New Roman",Times,serif;}
/* Style the header with a grey background and some padding */
.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

/* Style the header links */
.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px;
  line-height: 25px;
  border-radius: 4px;
}

/* Style the logo link (notice that we set the same value of line-height and font-size to prevent the header to increase when the font gets bigger */
.header a.logo {
  font-weight: bold;
}

/* Change the background color on mouse-over */
.header a:hover {
  background-color: #ddd;
  color: black;
}

/* Style the active/current link*/
.header a.active {
  background-color: dodgerblue;
  color: white;
}

/* Float the link section to the right */
.header-right {
  float: right;
}

/* Add media queries for responsiveness - when the screen is 500px wide or less, stack the links on top of each other */
@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  .header-right {
    float: none;
  }
}
</style>
