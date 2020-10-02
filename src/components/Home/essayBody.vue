<template>
    <div>
        <el-row type="flex" class="row-bg" justify="space-around">
            <el-col :span="6"><div class="grid-content bg-purple">  <Notice></Notice> </div></el-col>
            <el-col :span="6"><div class="grid-content bg-purple-light"><news></news> </div></el-col>
            <el-col :span="6"><div class="grid-content bg-purple"></div> <Introduction> </Introduction></el-col>
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
</style>
