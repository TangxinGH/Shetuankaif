<template>
  <a-table
      :row-key="record => record.Sno "
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
          <a @click="() => save(record.key)">Save</a>
          <a-popconfirm title="Sure to cancel?" @confirm="() => cancel(record.key)">
            <a>Cancel</a>
          </a-popconfirm>
        </span>
        <span v-else>
          <a :disabled="editingKey !== ''" @click="() => edit(record.key)">Edit</a>
        </span>
      </div>
    </template>
  </a-table>
</template>
<script>
const columns = [
  {
    title: '学号',
    dataIndex: 'Sno',
    width: '25%',
    scopedSlots: { customRender: 'name' }
  },
  {
    title: '名字',
    dataIndex: 'Sname',
    width: '15%',
    scopedSlots: { customRender: 'age' }
  },
  {
    title: '年龄',
    dataIndex: 'Age',
    width: '5%'
  },
  {
    title: '性别',
    dataIndex: 'Sex',
    width: '5%',
    scopedSlots: { customRender: 'address' }
  },
  {
    title: '是否加入社团',
    dataIndex: 'Joined',
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
  name: 'users',
  data () {
    this.cacheData = data.map(item => ({ ...item }))
    return {
      data,
      columns,
      editingKey: ''
    }
  },
  mounted () {
    this.$axios.get('/api/getUsers').then(res => {
      this.data = res.data.users.map((item) => { //  有同事指出应该声明一个新变量来存储map的结果，这个建议我认为是对的。
        return {
          ...item,
          Joined: item.Joined ? '加入' : '未加入'
        }
      })
      console.log(res.data.users)
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
