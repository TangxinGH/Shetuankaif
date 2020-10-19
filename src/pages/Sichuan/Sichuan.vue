<template>
<span> 登录 {{sname}}</span>
</template>

<script>
export default {
  name: 'Sichuan',
  data: function () {
    return {
      env: process.env.NODE_ENV === 'production',
      sname: ''
    }
  },
  mounted () {
    document.getElementById('loginhref').setAttribute('href', this.env ? './subscriber.html' : './subscriber')
    if (localStorage.getItem('sname')) this.sname = localStorage.getItem('sname')
  }
}
</script>

<style scoped>

</style>
