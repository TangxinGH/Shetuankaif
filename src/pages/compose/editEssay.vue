<template>
  <div>
<!--    <a-tabs type="card" @change="callback" >-->
<!--        <a-tab-pane key="editNews" tab="EditNews" >-->
<!--        Content of Tab Pane 1-->
<!--      </a-tab-pane>-->
<!--      <a-tab-pane key="editNotice" tab="EditNotice">-->
<!--        Content of Tab Pane 2-->
<!--      </a-tab-pane>-->
<!--      <a-tab-pane key="editMarkdown" tab="EditMarkdown">-->
<!--        Content of Tab Pane 3-->
<!--      </a-tab-pane>-->
<!--    </a-tabs>-->
<!--    <router-view></router-view>-->
    <markdown ref="child" :msg="content" :article_title="title"></markdown>
  </div>

</template>

<script>
import urljs from 'urijs'
import EditNotice from '@/pages/compose/category/editNotice'
import markdown from '@/components/Markdown/index.vue'
// import $ from 'jquery'

export default {
  name: 'editEssay',
  components: {
    markdown
  },
  data: function () {
    return {
      content: '',
      title: ''
    }
  },
  mounted () {
    let ntID = Number(new URLSearchParams(window.location.search).get('ntID'))
    let actID = Number(new URLSearchParams(window.location.search).get('actID'))
    console.log(ntID ? this.content_data = '?ntID=' + ntID : actID ? this.content_data = '?actID=' + actID : 1)
    this.$axios.get((ntID ? '/api/getNoticebyID' : '/api/getActivitybyID') + this.content_data).then(res => {
      console.log('数据输出 ')
      console.log(res.data)
      this.content = (res.data.ntContent ? res.data.ntContent : res.data.actContent)
      this.title = (res.data.actTitle ? res.data.actTitle : res.data.ntTitle)
    }).catch(err => {
      console.log(' 编辑文章 内容出错')
      console.log(err)
    })
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
      } else if (key === 'editNews') {
        this.$router.push({ path: '/editNews' })
      } else { this.$router.push({ path: '/markdown' }) }
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
