<template>
 <span>
      <a-divider type="vertical"/>
      <a-button @click="handleChangeSelect" icon="edit" /> <!--跳转到相应文章编辑-->
      <a-divider type="vertical"/>
      <a-button type="danger" @click="handleDelete">删除</a-button>
    </span>
</template>

<script>
export default {
  name: 'newsOperation',
  methods: {
    onChangeSwitch: function () {

    },
    handleDelete: function () {
      this.$message.success('删除成功')
    },
    handleChangeSelect: function () {
      this.$router.push({ path: '/editNews?actID=' })
    }
  }
}
</script>

<style scoped>

</style>
