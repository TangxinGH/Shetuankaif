<template>
 <div></div>
</template>

<script>
export default {
  name: 'newsOperation',
  methods: {
    onChangeSwitch: function () {

    },
    handleDelete: function (key) {
      // this.$axios.get('api/delNotice')
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
