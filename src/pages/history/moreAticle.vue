<template>
  <mdb-container>
    <h2 class="h1-responsive font-weight-bold text-center my-5">最近文章</h2>
    <p class="text-center w-responsive mx-auto mb-5"> 这里是历史文章，可以查看往期的活动新闻.</p>
    <div v-for="item in history_data" :key="item.ID">

      <mdb-row>
        <mdb-col lg="5" xl="4">
          <mdb-view hover class="rounded z-depth-1-half mb-lg-0 mb-4">
            <img class="img-fluid" src="https://source.unsplash.com/user/erondu/600x400" alt="Sample image"/>
            <a>
              <mdb-mask overlay="white-slight" waves/>
            </a>
          </mdb-view>
        </mdb-col>
        <mdb-col lg="7" xl="8">
          <h3 class="font-weight-bold mb-3 p-0">
            <strong>{{ item.Title }}</strong>
          </h3>
          <p class="dark-grey-text"> {{ item.Content }} </p>
          <p>by
            <a class="font-weight-bold">{{ item.Author }}</a>,{{ item.Publish_Time }}</p>
          <mdb-btn color="info" size="md"> <a style="color: #0e0f11"  v-bind:href="env ? './article.html?'+item.ID  : './article?'+item.ID" target="_blank"> 浏览</a> </mdb-btn>
        </mdb-col>
      </mdb-row>
      <hr class="my-5"/>
    </div>

  </mdb-container>
</template>
<script>
import { mdbContainer, mdbRow, mdbCol, mdbCard, mdbCardBody, mdbMask, mdbIcon, mdbView, mdbBtn } from 'mdbvue'
import moment from 'moment'

export default {
  name: 'BlogPage',
  components: {
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbCard,
    mdbCardBody,
    mdbMask,
    mdbIcon,
    mdbView,
    mdbBtn
  },
  data: function () {
    return {
      history_data: [],
      env: process.env.NODE_ENV === 'production'
    }
  },
  mounted () {
    let NtID = Number(new URLSearchParams(window.location.search).get('NtID'))
    console.log(NtID ? this.getHistoryNotices() : this.getHistoryActivitys()) // 选择调用
  },
  methods: {
    getHistoryNotices: function () {
      this.$axios.get('/api/getNotices').then(response => {
        // 压数据
        if (response.data.msg != null) {
          // if (response.code == 700) {
          console.log('history')
          console.log(response.data.msg)
          this.history_data = response.data.msg.map((item) => { //  有同事指出应该声明一个新变量来存储map的结果，这个建议我认为是对的。
            return {
              ...item,
              ID: 'NtID=' + item.NtID,
              Content: (function () {
                return item.Act_Content.slice(1, 200) ? item.Act_Content.slice(1, 200) : item.Act_Content
              })(),
              Publish_Time: moment(item.Nt_Publish_Time).format('YYYY-MM-DD'),
              Title: (function () {
                return item.Nt_Title.slice(1, 40) ? item.Nt_Title.slice(1, 40) : item.Nt_Title
              })()// 截取字符串.slice(4)  20 应该是最多吧
            }
          })
        }
        // }
      }).catch(function (err) {
        window.console.log('err', err)
      })
    },
    getHistoryActivitys: function () {
      this.$axios.get('/api/findAllActivities').then(response => {
        // 压数据
        if (response.data.msg != null) {
          // if (response.code == 700) {
          console.log('活动 history' + response.data.msg)
          this.history_data = response.data.msg.map((item) => { //  有同事指出应该声明一个新变量来存储map的结果，这个建议我认为是对的。
            return {
              ...item,
              ID: 'ActID=' + item.ActID,
              Content: (function () {
                return item.Act_Content.slice(1, 200) ? item.Act_Content.slice(1, 200) : item.Act_Content
              })(),
              Publish_Time: moment(item.Act_Publish_Time).format('YYYY-MM-DD'),
              Title: (function () {
                return item.Act_Title.slice(1, 40) ? item.Act_Title.slice(1, 40) : item.Act_Title
              })() // 截取字符串.slice(4)  20 应该是最多吧
            }
          })
          /* ~function() {}(); //当做表达式执行

!function() {}(); //当做表达式执行
void function() {}(); //当做表达式执行

(function() {})(); //函数的自我调用

(function(){}()); //函数的自我调用 */
        }
        // }
      }).catch(err => {
        window.console.log('err', err)
      })
    }
  }
}
</script>
