<template>
    <div class="g-doc">
      <nav-component></nav-component>
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
import NavComponent from '@/components/nav-component'
export default {
  name: 'index-app',
  components: {
    NavComponent,
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
