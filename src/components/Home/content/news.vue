<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>动态</span>
            <el-button style="float: right; padding: 3px 0" type="text">更多活动</el-button>
        </div>
        <div v-for="item in news_data" :key="item.ActID" class="text item" >
          <a-space :size="8" >
            <span  >  {{ item.Act_Publish_Time }}</span>
            <a-divider type="vertical" />
          <a  v-bind:href="item.ActID" target="_blank" >
          <span >  {{item.Act_Title }}…</span>
            <a-divider  type="vertical" />
          </a>
       <span  > {{ item.Act_Author }}</span>
          </a-space>
        </div>
    </el-card>
</template>

<script>
import moment from 'moment'
export default {
  name: 'news',
  data: function () {
    return {
      news_data: []
    }
  },
  created () {
    let self = this
    this.$axios.get('/api/articlesColumn').then(function (response) {
      // 压数据
      if (response.data.msg != null) {
        // if (response.code == 700) {
        self.news_data = response.data.msg
        debugger
        self.news_data = response.data.msg.map((item) => { //  有同事指出应该声明一个新变量来存储map的结果，这个建议我认为是对的。
          return {
            ...item,
            Act_Publish_Time: moment(item.Act_Publish_Time).format('MM-DD'),
            Act_Title: item.Act_Title.slice(1, 40) // 截取字符串.slice(4)  20 应该是最多吧
          }
        })
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
