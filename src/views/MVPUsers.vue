<template>
  <div>
    <a-table
        :row-key="record => record.adNo"
        :columns="columns"
        :data-source="data"
        bordered>
      <template
          v-for="col in ['name', 'age', 'address']"
          :slot="col"
          slot-scope="text, record, index"
      >
        <div :key="col">
          <a-input
              v-if="record.editable"
              style="margin: -5px 0"
              :value="text"
              @change="e => handleChange(e.target.value, record.key, col)"
          />
          <template v-else>
            {{ text }}
          </template>
        </div>
      </template>
      <template slot="operation" slot-scope="text, record, index">
        <div class="editable-row-operations">
        <span v-if="record.editable">
          <a @click="() => save(record.key)">保存</a>
          <a-popconfirm title="Sure to cancel?" @confirm="() => cancel(record.key)">
            <a>取消</a>
          </a-popconfirm>
        </span>
          <span v-else>
          <a :disabled="editingKey !== ''" @click="() => edit(record.key)">编辑</a>
        </span>

        </div>
      </template>
    </a-table>
    <a-divider/>
<!--    <add-admin/>-->
  </div>
</template>
<script>
import AddAdmin from '@/views/addAdmin'

const columns = [
  {
    title: '名字',
    dataIndex: 'adName',
    width: '25%',
    scopedSlots: { customRender: 'name' }
  },
  {
    title: 'ID',
    dataIndex: 'adNo',
    width: '15%',
    scopedSlots: { customRender: 'age' }
  },
  {
    title: '年龄',
    dataIndex: 'adAge',
    width: '5%'
  },
  {
    title: '性别',
    dataIndex: 'adSex',
    width: '5%',
    scopedSlots: { customRender: 'address' }
  },
  {
    title: '大学',
    dataIndex: 'adCollege',
    width: '10%'
  },
  {
    title: '操作',
    dataIndex: 'operation',
    scopedSlots: { customRender: 'operation' }
  }
]

const data = []
export default {
  name: 'MVPUsers',
  components: { AddAdmin },
  data () {
    this.cacheData = data.map(item => ({ ...item }))
    return {
      data,
      columns,
      editingKey: ''
    }
  },
  mounted () {
    this.$axios.get('/api/getAdmins').then(res => {
      console.log(res.data.adminsInfo)
      this.data = res.data.adminsInfo
    }).catch(err => {
      console.log(this + err)
    })
  },
  methods: {
    handleChange (value, key, column) {
      const newData = [...this.data]
      const target = newData.filter(item => key === item.key)[0]
      if (target) {
        target[column] = value
        this.data = newData
      }
    },
    edit (key) {
      const newData = [...this.data]
      const target = newData.filter(item => key === item.key)[0]
      this.editingKey = key
      if (target) {
        target.editable = true
        this.data = newData
      }
    },
    save (key) {
      const newData = [...this.data]
      const newCacheData = [...this.cacheData]
      const target = newData.filter(item => key === item.key)[0]
      const targetCache = newCacheData.filter(item => key === item.key)[0]
      if (target && targetCache) {
        delete target.editable
        this.data = newData
        Object.assign(targetCache, target)
        this.cacheData = newCacheData
      }
      this.editingKey = ''
    },
    cancel (key) {
      const newData = [...this.data]
      const target = newData.filter(item => key === item.key)[0]
      this.editingKey = ''
      if (target) {
        Object.assign(target, this.cacheData.filter(item => key === item.key)[0])
        delete target.editable
        this.data = newData
      }
    }

  }

}
</script>
<style scoped>
.editable-row-operations a {
  margin-right: 8px;
}
</style>
