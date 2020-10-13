<template>
    <div class="g-doc">
        <navigation></navigation>
      <a-divider/>
<!--      <blog-card style="margin-left: 60%"/>-->
      <FadingCarousel></FadingCarousel>
      <a-divider/>
        <HomeContent></HomeContent>
        <Footer></Footer>
    </div>
</template>
<script>
import navigation from '@/components/Home/navigation'
import HomeContent from '@/components/Home/essayBody'
import pageFooter from '@/components/Home/pageFooter'
import FadingCarousel from '@/views/FadingCarousel'
import blogCard from '@/views/About'
import JwcFooter from '@/views/jwcFooter'
export default {
  name: 'index-app',
  components: {
    blogCard,
    Footer: pageFooter,
    navigation,
    HomeContent,
    FadingCarousel
  },
  data () {
    return {
      page: Number(new URLSearchParams(window.location.search).get('page')) || 1,
      topics: [],
      items: [{ name: 'Malacca', url: 'https://farm9.staticflickr.com/8059/28286750501_dcc27b1332_h_d.jpg' },
        { name: 'Cameron Highland', url: 'https://farm6.staticflickr.com/5812/23394215774_b76cd33a87_h_d.jpg' },
        { name: 'New Delhi', url: 'https://farm8.staticflickr.com/7455/27879053992_ef3f41c4a0_h_d.jpg' },
        { name: 'Ladakh', url: 'https://farm8.staticflickr.com/7367/27980898905_72d106e501_h_d.jpg' },
        { name: 'Nubra Valley', url: 'https://farm8.staticflickr.com/7356/27980899895_9b6c394fec_h_d.jpg' }]

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
