<template>
    <el-container class="topHight">
      <jwc-footer/>
    </el-container>
</template>

<script>
import JwcFooter from '@/views/jwcFooter'
export default {
  name: 'pageFooter',
  components: { JwcFooter }
}
</script>

<style scoped>
    .topHight{
     margin-top: 20px;
        width: 100vw;
        //position:fixed;bottom:0px;left:0px;
    }
</style>
