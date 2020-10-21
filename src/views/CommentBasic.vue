<template>
  <div>
  <a-list
      class="comment-list"
      :header="`${data.length} replies`"
      item-layout="horizontal"
      :data-source="data"
  >
    <a-list-item slot="renderItem" slot-scope="item, index">
      <a-comment :author="item.author" :avatar="item.avatar">
        <template slot="actions">
          <span v-for="action in item.actions">{{ action }}</span>
        </template>
        <p slot="content">
          {{ item.content }}
        </p>
        <a-tooltip slot="datetime" :title="item.datetime.format('YYYY-MM-DD HH:mm:ss')">
          <span>{{ item.datetime.fromNow() }}</span>
        </a-tooltip>
      </a-comment>
    </a-list-item>
  </a-list>

    <a-textarea placeholder="发表一下评论吧" v-model="commentSubmit"> </a-textarea>
    <a-button @click="submitComments" style="float: right ; margin-top: 15px; margin-bottom: 20px; color: yellow"  type="primary">发布</a-button>
  </div>
</template>
<script>
import moment from 'moment'

export default {
  name: 'CommentBasic',
  data () {
    return {
      data: [
        {
          actions: ['Reply to'],
          author: 'Han Solo',
          avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
          content:
              'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
          datetime: moment().subtract(1, 'days')
        },
        {
          actions: ['Reply to'],
          author: 'Han Solo',
          avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
          content:
              'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
          datetime: moment().subtract(2, 'days')
        }
      ],
      moment,
      commentSubmit: '',
      ntID: null,
      actID: null,
      content_data: null
    }
  },
  mounted () {
    let ntID = Number(new URLSearchParams(window.location.search).get('ntID'))
    let actID = Number(new URLSearchParams(window.location.search).get('actID'))
    ntID ? this.ntID = ntID : this.actID = actID
    this.$axios.get('/api/getComments', { params: { actID: actID } }).then(res => {
      // 从接口得到数据 常见于数据
      console.log(res)
      /* map() 方法返回一个新数组，数组中的元素为原始数组元素调用函数处理后的值。

map() 方法按照原始数组元素顺序依次处理元素。

注意： map() 不会对空数组进行检测。

注意： map() 不会改变原始数组。 */
      this.data = res.data.comments.map(item => ({
        ...item,
        author: item.sno,
        content: item.cmtContent,
        datetime: moment(item.cmtDate)
      }))
      console.log('输出映射后的评论数据')
      console.log(this.data)
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    submitComments: function () {
      if (this.commentSubmit == '') {
        this.$message.error('内容不能为空')
        return
      }
      if (!(localStorage.getItem('user') ? localStorage.getItem('user') : localStorage.getItem('admin'))) {
        this.$message.error('你没有登录！')
        return
      }
      let user = JSON.parse(localStorage.getItem('user'))
      let admin = JSON.parse(localStorage.getItem('admin'))
      this.data.push({
        author: localStorage.getItem('sname'),
        content: this.commentSubmit,
        datetime: moment()
      })
      let config = {
        params: {
          sno: user.sno ? user.sno : admin.sno,
          sname: localStorage.getItem('sname'),
          commentContent: this.commentSubmit,
          actID: this.actID
        }
      }
      this.$axios.post('api/addComment', null, config).then(res => {
        if (res.data.code == -50000) { this.$message.success('发表成功') } else this.$message.error(res.data.msg)
      }).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>
