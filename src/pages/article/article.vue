<template>
    <div class="g-doc">
      <ArticleLayout/>
<ArticleContent></ArticleContent>
      <CommentBasic></CommentBasic>
    </div>
</template>
<script>
import ArticleLayout from '@/components/Article/ArticleLayout'
import ArticleContent from '@/components/Article/ArticleContent'
import CommentBasic from '@/views/CommentBasic'
export default {
  name: 'index-app',
  components: {
    CommentBasic,
    ArticleContent,
    ArticleLayout
  },
  data () {
    return {
      page: Number(new URLSearchParams(window.location.search).get('page')) || 1,
      topics: [],
      hasEssay: true
    }
  },
  async mounted () {
    // const { success, data } = await api.get('topics', { page: this.page })
    // if (success) this.topics = data
  },
  metaInfo: {
    title: '文章'
  }
}

</script>
<style scoped>
</style>
