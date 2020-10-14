<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>公告</span>
            <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
        </div>
      <div v-for="item in notice_data" :key="item.NtID" class="text item" >
        <a-space :size="8" >
          <span  >  {{ item.Nt_Publish_Time }}</span>
          <a-divider type="vertical" />
          <a  v-bind:href="item.NtID" target="_blank" >
            <span >  {{item.Nt_Title() }}…</span>
            <a-divider  type="vertical" />
          </a>
          <span  > {{ item.Nt_Author }}</span>
        </a-space>
      </div>
    </el-card>
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
            Nt_Publish_Time: moment(item.Nt_Publish_Time).format('MM-DD'),
            Nt_Title: function () { return item.Nt_Title.slice(1, 40) ? item.Nt_Title.slice(1, 40) : item.Nt_Title } // 截取字符串.slice(4)  20 应该是最多吧
          }
        })
      }
      // }
    }).catch(function (err) {
      window.console.log('err', err)
    })
  },
  data: function () {
    return {
      notice_data: []
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
