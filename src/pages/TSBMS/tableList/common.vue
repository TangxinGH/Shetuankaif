<template ref="comA">
  <div>
    <p> {{this.$route.query.name}}</p>
  <a-table
      :columns="columns"
      :row-key="record => record.actID ? record.actID : record.ntID"
      :data-source="data"
      :pagination="pagination"
      :loading="loading"
      @change="handleTableChange"
      bordered
  >
    <template slot="name" slot-scope="name"> {{ name.first }} {{ name.last }}</template>
    <span slot="aHref" slot-scope="text, record">
      <a target="_blank" v-bind:href="(env ? '/article.html?' : '/article?') + (record.actID ? 'actID='+ record.actID : 'ntID='+ record.ntID)"> {{ record.actTitle ? record.actTitle : record.ntTitle}}</a>
    </span>
   <news-operation  slot="action" slot-scope="text, record"></news-operation>
  </a-table>
  </div>
</template>
<script>
import reqwest from 'reqwest'
import columnsData from '@/pages/TSBMS/tableList/columns_data'
import NewsOperation from '@/pages/TSBMS/tableList/operation/newsOperation'
import { EventBus } from '@/pages/TSBMS/tableList/operation/event-bus'

const articlesColumn = columnsData.newsData
const allCommentsColumn = columnsData.AllComments
const NoticesColumn = columnsData.Notices

export default {
  name: 'common',
  components: { NewsOperation },
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
    EventBus.$on('browseNews', param => { this.fetch('/api/findAllActivities'); this.columns = articlesColumn; window.console.log(param.to + 'evenbus') })
    EventBus.$on('browseComment', param => { this.fetch('/api/getAllComments'); this.columns = allCommentsColumn; console.log(param.to + 'evenbus') })
    EventBus.$on('browseNotice', param => { this.fetch('/api/getNotices'); this.columns = NoticesColumn; console.log(param.to + 'evenbus') })
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
        this.data = data.msg // 赋于数据
        this.pagination = pagination
      })
    }
  }
}
</script>
<style scoped>

</style>
