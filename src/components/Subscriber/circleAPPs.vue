<template>
    <ul class='circle-container'>
      <!--    v-slot:"boxImg" 不能加双引呈 ，不能用slot="" 因为已经废弃 无法使用，而且不报错。fuck-->
      <neumorphism v-for="n in 8" :key="n"><!-- neumorphism 有多个的slot name 时 ，这才是正确的写法-->
        <template v-slot:boxImg><img src='http://lorempixel.com/100/100/city'></template>
        <template v-slot:ImgName><p>沒文憑{{ n }}</p></template>
      </neumorphism>
    </ul>
</template>

<script>
import Neumorphism from '@/views/neumorphism'

export default {
  name: 'circleAPPs',
  components: { Neumorphism }
}
</script>

<style scoped>

.circle-container {
  position: relative;
  width: 25em;
  height: 25em;
  border-radius: 50%;
  padding: 0;
  list-style: none;
  margin: 8em auto 0;
  border: solid 5px tomato;

}

.circle-container > * {
  display: block;
  position: absolute;
  top: 50%;
  left: 50%;
  margin: -4em;
  width: 6em;
  height: 6em;
}

.circle-container > *:nth-of-type(1) {
  transform: rotate(0deg) translate(10em) rotate(0deg);
}

.circle-container > *:nth-of-type(2) {
  transform: rotate(45deg) translate(10em) rotate(-45deg);
}

.circle-container > *:nth-of-type(3) {
  transform: rotate(90deg) translate(10em) rotate(-90deg);
}

.circle-container > *:nth-of-type(4) {
  transform: rotate(135deg) translate(10em) rotate(-135deg);
}

.circle-container > *:nth-of-type(5) {
  transform: rotate(180deg) translate(10em) rotate(-180deg);
}

.circle-container > *:nth-of-type(6) {
  transform: rotate(225deg) translate(10em) rotate(-225deg);
}

.circle-container > *:nth-of-type(7) {
  transform: rotate(270deg) translate(10em) rotate(-270deg);
}

.circle-container > *:nth-of-type(8) {
  transform: rotate(315deg) translate(10em) rotate(-315deg);
}

.circle-container img {
  display: block;
  max-width: 100%;
  border-radius: 25%;/*圆角度*/
  filter: grayscale(100%);
  border: solid 5px tomato;
  transition: .15s;
}

.circle-container img:hover {
  filter: grayscale(0);
  /*颜色*/
}

</style>
