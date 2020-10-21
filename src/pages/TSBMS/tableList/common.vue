<template ref="comA">
  <div>
    <p> {{ this.$route.query.name }}</p>
    <a-input-search style="width: 200px; float: right" placeholder="输入关健词搜索" enter-button @search="onSearch"/>
    <br/><br/><br/>
    <a-table
        :columns="columns"
        :row-key="record => record.cmtID ? record.cmtID : record.ntID ? record.ntID :record.actID"
        :data-source="data"
        :pagination="pagination"
        :loading="loading"
        @change="handleTableChange"
        bordered
    >
      <template slot="name" slot-scope="name"> {{ name.first }} {{ name.last }}</template>
      <span slot="aHref" slot-scope="text, record">
      <a target="_blank"
         v-bind:href="(env ? '/article.html?' : '/article?') + (record.actID ? 'actID='+ record.actID : 'ntID='+ record.ntID)"> {{
          record.actTitle ? record.actTitle : record.ntTitle
        }}</a>
    </span>
      <template slot="action" slot-scope="text, record">
        <span>
      <a-divider type="vertical"/>
      <a-button @click="handleEdit(record)" icon="edit"/> <!--跳转到相应文章编辑-->
      <a-divider type="vertical"/>
        <a-popconfirm
            v-if="data.length"
            title="确定删除?"
            @confirm="() => handleDelete(record.actID? record.actID : record.ntID ? record.ntID : record.cmtID,
            record.actID ? 'actID' : record.ntID ? 'ntID' : 'cmtID')"
        ><a href="javascript:;">删除</a>
              </a-popconfirm>
    </span>
      </template>

    </a-table>

  </div>
</template>
<script>
import reqwest from 'reqwest'
import columnsData from '@/pages/TSBMS/tableList/columns_data'
import NewsOperation from '@/pages/TSBMS/tableList/operation/newsOperation'
import { EventBus } from '@/pages/TSBMS/tableList/operation/event-bus'
import AddGroup from '@/pages/TSBMS/tableList/addGroup'

const articlesColumn = columnsData.newsData
const allCommentsColumn = columnsData.AllComments
const NoticesColumn = columnsData.Notices

export default {
  name: 'common',
  components: {
    AddGroup,
    NewsOperation
  },
  props: ['routerChange'],
  data () {
    return {
      env: process.env.NODE_ENV === 'production',
      data: [],
      pagination: {},
      loading: false,
      articles: articlesColumn,
      getNotices: NoticesColumn,
      getAllComments: allCommentsColumn,
      columns: articlesColumn // 默认
    }
  },
  watch: {
    routerChange: function () {
      console.log('数据改变了')
    }
  },
  mounted () {
    this.fetch('/api/findAllActivities') // 默认
    EventBus.$on('browseNews', param => {
      this.fetch('/api/findAllActivities')
      this.columns = articlesColumn
      window.console.log(param.to + 'evenbus')
    })
    EventBus.$on('browseComment', param => {
      this.fetch('/api/getAllComments')
      this.columns = allCommentsColumn
      console.log(param.to + 'evenbus')
    })
    EventBus.$on('browseNotice', param => {
      this.fetch('/api/getNotices')
      this.columns = NoticesColumn
      console.log(param.to + 'evenbus')
    })
  },
  methods: {
    handleTableChange (pagination, filters, sorter) {
      console.log(pagination)
      const pager = { ...this.pagination }
      pager.current = pagination.current
      this.pagination = pager
      // this.fetch({  //让服务器来排序
      //   results: pagination.pageSize,
      //   page: pagination.current,
      //   sortField: sorter.field,
      //   sortOrder: sorter.order,
      //   ...filters
      // })
    },

    fetch (url, params = {}) { // 获取数据
      console.log('params:', params)
      this.loading = true
      reqwest({
        url: url,
        method: 'get',
        data: {
          results: 10,
          ...params
        },
        type: 'json'
      }).then(data => {
        const pagination = { ...this.pagination }
        // Read total count from server
        // pagination.total = data.totalCount;
        console.log(data)
        pagination.total = 200
        this.loading = false
        this.data = data.activities ? data.activities : data.notices ? data.notices : data.comments // 赋于数据
        this.pagination = pagination
      })
    },
    onSearch: function () {

    },

    handleDelete: function (key, type) {
      if (!key) {
        this.$message.error('传值错误')
        return
      }
      const dataSource = [...this.data]
      this.data = dataSource.filter(item => item[type] !== key) // 删除行

      if (type == 'ntID') { this.$axios.get('/api/delNotice?ntID=' + key).then(res => { this.$message.success('删除成功') }); return }
      if (type == 'cmtID') { this.$axios.get('/api/DelComment?cmtID=' + key).then(res => { this.$message.success('删除成功') }); return }// api/DelComment
      if (type == 'actID') { this.$axios.get('/api/deleteAcivityByID?actID=' + key).then(res => { this.$message.success('删除成功') }) }// deleteAcivityByID
    },
    handleEdit: function (record) {
      record.actID ? window.open('/compose.html?actID=' + record.actID, '_blank') : record.ntID ? this.$router.push({ path: '/editNews' }) : this.$router.push({ path: '/editNews' })
    }
  }
}
</script>
<style scoped>

</style>
