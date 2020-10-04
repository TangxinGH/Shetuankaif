<template>
  <div>
    <a-tabs type="card" @change="callback" >
        <a-tab-pane key="editNews" tab="EditNews" >
        Content of Tab Pane 1
      </a-tab-pane>
      <a-tab-pane key="editNotice" tab="EditNotice">
        Content of Tab Pane 2
      </a-tab-pane>
      <a-tab-pane key="editMarkdown" tab="EditMarkdown">
        Content of Tab Pane 3
      </a-tab-pane>
    </a-tabs>
    <router-view></router-view>
  </div>

</template>

<script>
import urljs from 'urijs'
import EditNotice from '@/pages/compose/category/editNotice'
// import $ from 'jquery'

export default {
  name: 'editEssay',
  data: function () {
    return {}
  },
  methods: {
    // handleChange (value) {
    //   if (value === 'editNotice') {
    //     this.$router.push({ path: '/editNotice' })
    //   } else {
    //     this.$router.push({ path: '/editNews' })
    //   }
    //
    //   console.log(value) // { key: "lucy", label: "Lucy (101)" }
    // },
    callback (key) {
      console.log(key)
      if (key === 'editNotice') {
        this.$router.push({ path: '/editNotice' })
      } else {
        this.$router.push({ path: '/editNews' })
      }
    },
    funurl: function () {
      console.log('url sss' + 'window.location.href:' + window.location.href + 'this.$route.params:' + this.$route.params)
      const url = window.location.href // 获取当前url
      const dzUrl = url.split('#')[0]// 获取#/之前的字符串
      let cs = dzUrl.split('?')[1]// 获取?之后的参数字符串
      const csArr = cs.split('&')// 参数字符串分割为数组
      cs = {}
      for (let i = 0; i < csArr.length; i++) { // 遍历数组，拿到json对象
        cs[csArr[i].split('=')[0]] = csArr[i].split('=')[1]
      }
      this.id = cs.id // 这样就拿到了参数中的数据
      /* this.$router.push({name:"B",query:{
同页面内
     Id : this.tId ,

    ...

}}) */
      // 链接：https://juejin.im/post/6844903933735862286
    }
  }
}
</script>

<style lang="less" scoped>

</style>
