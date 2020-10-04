<template>
    <div class="g-doc">
        <navigation></navigation>
        <Carousel></Carousel>
        <HomeContent></HomeContent>
        <Footer></Footer>
<!--        <modules :topics="topics" :page="page" />-->
    </div>
</template>
<script>
import navigation from '@/components/Home/navigation'
import Carousel from '@/components/Home/Carousel'
import HomeContent from '@/components/Home/essayBody'
import pageFooter from '@/components/Home/pageFooter'
export default {
  name: 'index-app',
  components: {
    Footer: pageFooter,
    navigation,
    Carousel,
    HomeContent
  },
  data () {
    return {
      page: Number(new URLSearchParams(window.location.search).get('page')) || 1,
      topics: []
    }
  },
  async mounted () {
  },
  metaInfo: {
    title: '首页'
  }
}
</script>
<style scoped>
.g-doc{
  margin-top: 10px;
}
</style>
