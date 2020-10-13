<template ref="comA">
  <div>
    <p> {{this.$route.query.name}}</p>
  <a-table
      :columns="columns"
      :row-key="record => record.ActID ? record.ActID : record.NotID"
      :data-source="data"
      :pagination="pagination"
      :loading="loading"
      @change="handleTableChange"
      bordered
  >
    <template slot="name" slot-scope="name"> {{ name.first }} {{ name.last }}</template>
    <span slot="aHref" slot-scope="text, record">
      <a> {{ record.Act_Title }}</a>
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

const columns = columnsData.newsData
const col = columnsData.columns2
export default {
  name: 'common',
  components: { NewsOperation },
  props: ['routerChange'],
  rotername: '',
  data () {
    return {
      data: [],
      pagination: {},
      loading: false,
      columns
    }
  },
  watch: {
    routerChange: function () {
      console.log('数据改变了')
    }
  },
  mounted () {
    this.fetch()
    console.log('传参数' + this.$route.query.name)
    EventBus.$on('addition', param => {
      console.log('evenbus')
    })
  },
  updated () {
    console.log('updated 传参数' + this.$route.query.name)
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
    buttonclick: function () {
      this.data = col
    },
    fetch (params = {}) {
      console.log('params:', params)
      this.loading = true
      reqwest({
        url: '/api/articles', // getNotices
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
        this.data = data.msg
        this.pagination = pagination
      })
    }
  }
}
</script>
<style scoped>

</style>
