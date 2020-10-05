<template>
    <div>
        <el-row class="row-bg" >
            <el-col :xs="{ span: 16, offset: 8 }" :md="{ span: 6, offset: 1 }" :lg="{ span: 6, offset: 2 }" ><div class="grid-content bg-purple">  <Notice></Notice> </div></el-col>
            <el-col :xs="{ span: 16, offset: 8 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 1 }"><div class="grid-content bg-purple-light"><news></news> </div></el-col>
            <el-col :xs="{ span: 16, offset: 8 }" :md="{ span: 6, offset: 0 }" :lg="{ span: 6, offset: 1 }"><div class="grid-content bg-purple"></div> <Introduction> </Introduction></el-col>
        </el-row>
    </div>
</template>

<script>
import Introduction from '@/components/Home/content/Introduction'
import Notice from '@/components/Home/content/notice'
import News from '@/components/Home/content/news'

export default {
  name: 'essayBody',
  components: { Introduction, News, Notice }
}
</script>

<style scoped>
@import "https://fonts.googleapis.com/css2?family=Ma+Shan+Zheng&family=Noto+Serif+SC:wght@200&display=swap";
*{
  font-family: 'Noto Serif SC', serif;
  }
</style>
