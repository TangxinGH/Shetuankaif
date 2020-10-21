<template>
  <div>
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
          <a @click="() => save(record.key)">保存</a>
          <a-popconfirm title="确定取消?" @confirm="() => cancel(record.sno)">
            <a>取消</a>
          </a-popconfirm>
        </span>
        <span v-else>
          <a :disabled="editingKey !== ''" @click="() => edit(record.sno)">编辑</a>
        </span>
        <a-divider type="vertical"/>
        <span>添加为管理员  <a-switch  @change="onSwitchChange(record.sno)"></a-switch> </span>
        <a-divider type="vertical"/>
        <a-popconfirm
            v-if="data.length"
            title="确定删除?"
            @confirm="() => handleDelete(record.sno)"
        ><a href="javascript:;">删除</a>
        </a-popconfirm>
      </div>
    </template>
  </a-table>
    <a-divider/>
    <add-group> </add-group>
  </div>
</template>
<script>
import AddGroup from '@/pages/TSBMS/tableList/addGroup'
const columns = [
  {
    title: '学号',
    dataIndex: 'sno',
    width: '25%',
    scopedSlots: { customRender: 'name' }
  },
  {
    title: '名字',
    dataIndex: 'sname',
    width: '15%',
    scopedSlots: { customRender: 'age' }
  },
  {
    title: '年龄',
    dataIndex: 'age',
    width: '5%'
  },
  {
    title: '性别',
    dataIndex: 'sex',
    width: '5%',
    scopedSlots: { customRender: 'address' }
  },
  {
    title: '是否加入社团',
    dataIndex: 'joined',
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
  components: { AddGroup },
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
      this.data = res.data.userinfo.map((item) => { //  有同事指出应该声明一个新变量来存储map的结果，这个建议我认为是对的。
        return {
          ...item,
          joined: item.joined ? '加入' : '未加入'
        }
      })
      console.log(res.data.userinfo)
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
    },
    handleDelete: function (key) {
      if (!key) {
        this.$message.error(`传值错误 ${key}`)
        return
      }
      const dataSource = [...this.data]
      this.data = dataSource.filter(item => item.sno !== key) // 删除行
      this.$message.success('删除成功')
      this.$axios.delete('/api/delUser?sno=' + key).then(res => {

      }).catch(err => {

      })
    },
    onSwitchChange: function (sno) {
      this.$axios.get('/api/addAdmin', null, { params: { sno: sno, adNo: JSON.parse(localStorage.getItem('admin')).adNo } }).then(res => {
        this.$message.success(`添加管理员状态:${sno}  ${res.data}`)
      }).catch(err => {
        console.log(`增加管理员${err}`)
      })
    }
  }
}
</script>
<style scoped>
.editable-row-operations a {
  margin-right: 8px;
}
</style>
