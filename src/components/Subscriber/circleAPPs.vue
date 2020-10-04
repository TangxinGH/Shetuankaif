<template>
  <div class="circleAPPs">
    <ul class='circle-container'>
      <!--    v-slot:"boxImg" 不能加双引呈 ，不能用slot="" 因为已经废弃 无法使用，而且不报错。fuck-->
      <neumorphism v-for="n in 8" :key="n"><!-- neumorphism 有多个的slot name 时 ，这才是正确的写法-->
        <template v-slot:boxImg><img src='http://lorempixel.com/100/100/city'></template>
        <template v-slot:ImgName><p>沒文憑{{ n }}</p></template>
      </neumorphism>
    </ul>
  </div>
</template>

<script>
import Neumorphism from '@/views/neumorphism'

export default {
  name: 'circleAPPs',
  components: { Neumorphism }
}
</script>

<style scoped>
.circleAPPs{
  margin-top: 10%;
  margin-left: 5%;
  float: left;
}
</style>
