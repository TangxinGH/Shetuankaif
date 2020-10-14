<template>
  <mdb-container class="z-depth-1">
    <section class="my-0">
      <br>
      <h2 class="h2-responsive font-weight-bold text-center my-1"><img src="https://static01.imgkr.com/temp/9ff946cf590e41c9a5f5bb8aace6e241.png"/></h2>
<!--      <p class="lead grey-text w-responsive text-center mx-auto mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.</p>-->
      <mdb-row class="my-4">
        <mdb-col lg="4" class="text-center text-lg-left">
          <img class="img-fluid" src="../../assets/img/publicity.png" />
        </mdb-col>
        <mdb-col lg="7">
          <mdb-row class="mb-3">
            <mdb-col size="1">
              <br>
              <mdb-icon icon="share" size="lg" class="indigo-text"/>
            </mdb-col>
            <mdb-col xl="10" md="11" size="10">
              <br>
              <h5 class=" mb-3">黄色</h5>
              <p class="grey-text">1、黄色的背景，轻快活泼，寓意鲲鹏素拓协会充满活力和希望。 </p>
              <!--4、背面的猫爪造型,象征鳃鹏家族凝聚和谐的精神风
貌,在会长团的统筹下,五个部门分工合作、相互配合
共同奋斗!-->
            </mdb-col>
          </mdb-row>
          <mdb-row class="mb-3">
            <mdb-col size="1">
              <mdb-icon icon="share" size="lg" class="indigo-text"/>
            </mdb-col>
            <mdb-col xl="10" md="11" size="10">
              <h5 class=" mb-3">寓意</h5>
              <p class="grey-text">2、正面右上角向上腾飞的大鹏展开双翅，寓意鲲鹏家族飞得更高、飞得更远。</p>
            </mdb-col>
          </mdb-row>
          <mdb-row class="mb-3">
            <mdb-col size="1">
              <mdb-icon icon="share" size="lg" class="indigo-text"/>
            </mdb-col>
            <mdb-col xl="10" md="11" size="10">
              <h5 class=" mb-3"> 人际</h5>
              <p class="grey-text">3、正面下方手拉手站成一排的小人与上面的宣传语遥相
                呼应,预示餛鹏素拓在带大家一起玩的同时,可以收获友
                情,锻炼胆量,提升口才、主持、临场应变等能力。</p>
            </mdb-col>
          </mdb-row>
          <p class=" grey-text w-responsive text-center ">(设计by王紫琪)</p>
        </mdb-col>
      </mdb-row>
    </section>
  </mdb-container>
</template>
<script>
import { mdbContainer, mdbRow, mdbCol, mdbIcon, mdbBtn } from 'mdbvue'

export default {
  name: 'FeaturesPage',
  components: {
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbIcon,
    mdbBtn
  }
}
</script>
<style  scoped>
</style>
