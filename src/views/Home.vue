<template>
  <div>
  <a-card hoverable style="width: 400px">
    <a href="/index.html">前往首页</a>
    <p/>
    <h5>个人信息</h5>
    <a-divider/>
    <a-card-meta >
      <template slot="description">
        <a-avatar  icon="user"  slot="avatar"
                   src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
        <p/>
        <p> 学号： {{info.sno}}</p>
        <p>名字： {{ info.sname}} </p>
        <p> 大学： {{ info.scollege}}</p>
      </template>
    </a-card-meta>
    <span>是否加入社团：</span>
    <a-switch @change="joinSheTuan"></a-switch>
    <template slot="actions" class="ant-card-actions">
      <a-icon key="setting" type="setting" />
      <a-icon key="edit" type="edit" />
      <a-icon key="ellipsis" type="ellipsis" />
    </template>
  </a-card>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Home',
  data () {
    return {
      metaInfo: '>Home - Vincie.web',
      info: ''
    }
  },
  methods: {
    joinSheTuan: function (checked) {
      this.$axios.get('/api/joinCommunity?sno=' + this.info.sno).then(res => {
        this.$message.success(`${checked ? '加入社团成功，交费即可自动审核通过 ヾ(≧▽≦*)o' : '退出社团成功 ค(TㅅT)ค(TㅅT)'}`)
      }).catch(err => {
        this.$message.warning(' 服务开小差了 ค(TㅅT)ค(TㅅT)')
        console.log(`${err}`)
      })
    }
  },
  mounted () {
    this.info = JSON.parse(localStorage.getItem('user'))
    // this.$axios.post('api/userinfo').then(res=>{
  }
}
</script>
<style scoped>
div
{
/*  box-shadow: 1px 1px 1px 2px #888888;*/
  text-align: center;
}
</style>
