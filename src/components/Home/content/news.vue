<template>
    <a-card class="box-card">
        <div slot="header" class="clearfix">
            <span>动态</span>
          <a-button style="float: right; padding: 3px 0" type="text"><a v-bind:href="env ? './history.html' : './history'" target="_blank">更多活动</a></a-button>
        </div>
        <div v-for="item in news_data" :key="item.actID" class="text item" >
          <a-space :size="8" >
            <span  >  {{ item.actPublishTime }}</span>
            <a-divider type="vertical" />
          <a  v-bind:href="env ? './article.html?actID='+item.actID : './article?actID='+item.actID" target="_blank" >
          <span >  {{item.actTitle }}…</span>
            <a-divider  type="vertical" />
          </a>
       <span  > {{ item.actAuthor }}</span>
          </a-space>
        </div>
    </a-card>
</template>

<script>
import moment from 'moment'
export default {
  name: 'news',
  data: function () {
    return {
      news_data: [],
      env: process.env.NODE_ENV === 'production'
    }
  },
  created () {
    this.$axios.get('/api/findAllActivities').then(response => {
      // 压数据
      if (response.data.msg != null) {
        // if (response.code == 700) {
        this.news_data = response.data.msg
        console.log('活动 home' + response.data.msg)
        this.news_data = response.data.msg.map((item) => { //  有同事指出应该声明一个新变量来存储map的结果，这个建议我认为是对的。
          return {
            ...item,
            actPublishTime: moment(item.actPublishTime).format('MM-DD'),
            actTitle: (function () { return item.actTitle.slice(1, 40) ? item.actTitle.slice(1, 40) : item.actTitle })() // 截取字符串.slice(4)  20 应该是最多吧
          }
        })
        this.$emit('parentFunctionNews', this.news_data[0]) // 向父组件传值
      }
      // }
    }).catch(function (err) {
      window.console.log('err', err)
    })
  },
  methods: {

  }
}
</script>

<style scoped>
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }
</style>
