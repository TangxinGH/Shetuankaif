<template>
    <div class="nav-wrap">
        <ul class="nav-block">
            <li class="logo"><img src="http://img.daliangju.com/upload/20180603/1528019409246zkdt80.png" alt="" /></li>
            <li :class="{ current: current === 1 }">
                <a v-bind:href="env? './index.html' : './index'"><i></i>首页</a>
            </li>
            <li :class="{ current: current === 2 }">
                <a v-bind:href="env ? './article.html' : './article'"><i></i>article</a>
            </li>
            <li :class="{ current: current === 3 }">
                <a v-bind:href="env ? './compose.html' : './compose'"><i></i>编辑文章</a>
            </li>
            <li :class="{ current: current === 4 }">
                <a v-bind:href="env ? './subscriber.html' : './subscriber'"><i></i>subscriber登录</a>
            </li>
            <li :class="{ current: current === 5 }">
                <a v-bind:href="env ? './tsbms.html' : './tsbms'"><i></i>Vuex</a>
            </li>
        </ul>
    </div>
</template>
<script>
export default {
  props: ['current'],
  data: function () {
    return {
      env: process.env.NODE_ENV === 'production' // I think that you should avoid using process directly in template and you can use computed for proxying.
    }
  }
}
</script>
