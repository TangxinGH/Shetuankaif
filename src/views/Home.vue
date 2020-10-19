<template>
  <div>
    <hello-world></hello-world>
<p> 学号： {{info.sno}}</p>
    <p>名字： {{ info.sname}} </p>
    <p> 大学： {{ info.scollege}}</p>
  </div>

</template>

<script>
// @ is an alias to /src
import drawer from '@/components/TSBMS/drawer'

export default {
  name: 'Home',
  components: {
    HelloWorld: drawer
  },
  data () {
    return {
      metaInfo: '>Home - Vincie.web',
      info: ''
    }
  },
  mounted () {
    this.info = JSON.parse(localStorage.getItem('user'))
    // this.$axios.post('api/userinfo').then(res=>{
  }
}
</script>
<style scoped>

</style>
