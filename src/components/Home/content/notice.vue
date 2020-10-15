<template>
    <a-card class="box-card">
        <div slot="header" class="clearfix">
            <span>公告</span>
            <a-button style="float: right; padding: 3px 0" type="text"><a v-bind:href="env ? './history.html?ntID=1' : './history?ntID=1'" target="_blank">更多</a></a-button>
        </div>
      <div v-for="item in notice_data" :key="item.ntID" class="text item" >
        <a-space :size="8" >
          <span  >  {{ item.ntPublishTime }}</span>
          <a-divider type="vertical" />
          <a  v-bind:href="env ? './article.html?ntID='+item.ntID : './article?ntID='+item.ntID" target="_blank">
            <span >  {{item.ntTitle }}…</span>
            <a-divider  type="vertical" />
          </a>
          <span  > {{ item.ntAuthor }}</span>
        </a-space>
      </div>
    </a-card>
</template>

<script>
import moment from 'moment'

export default {
  name: 'notice',
  created () {
    this.$axios.get('/api/getNotices').then(response => {
      // 压数据
      if (response.data.msg != null) {
        // if (response.code == 700) {
        this.notice_data = response.data.msg
        console.log('公告')
        console.log(response.data.msg)
        this.notice_data = response.data.msg.map((item) => { //  有同事指出应该声明一个新变量来存储map的结果，这个建议我认为是对的。
          return {
            ...item,
            ntPublishTime: moment(item.ntPublishTime).format('MM-DD'),
            ntTitle: (function () { return item.ntTitle.slice(1, 80) ? item.ntTitle.slice(1, 80) : item.ntTitle })() // 截取字符串.slice(4)  20 应该是最多吧
          }
        })
        this.$emit('parentFunctionNotice', this.notice_data[0]) // 向父组件传值
      }
      // }
    }).catch(function (err) {
      window.console.log('err', err)
    })
  },
  data: function () {
    return {
      notice_data: [],
      env: process.env.NODE_ENV === 'production'
    }
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
