<template>
  <div>
    <hello-world></hello-world>

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
      metaInfo: '>Home - Vincie.web'
    }
  }
}
</script>
<style scoped>

</style>
