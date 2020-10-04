<template>
  <div class="neumorphism"  >
    <div class="box">
      <div class="boxImg">
<!--        slot 里不为空，即是默认内容-->
        <slot name="boxImg"><img src='http://lorempixel.com/100/100/city'></slot>
      </div>
     <slot name="ImgName"><p>应用中心</p></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'neumorphism'
}
</script>

<style scoped>

.neumorphism{
  width: auto;
  height: auto;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  align-items: center;
}
.neumorphism .box{
  display: flex;
  justify-content: space-around;
  flex-direction: column;
  align-items: center;
  align-content: center;
  width: 100px;
  height: 140px;
  margin: 20px;
}
.neumorphism .box .boxImg{
  width: 100px;
  height: 100px;
  box-shadow: 18px 18px 30px rgba(0, 0, 0, 0.1),
  -18px -18px 30px rgba(255, 255, 255, 1);
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #efeeee;
  transition: box-shadow .2s ease-out;
  position: relative;
}

.neumorphism .box .boxImg  .tag_img{
  width: 60px;
  transition: width 0.2s ease-out;
}
.neumorphism .box p{
  color: slategrey;
}
.neumorphism .box .boxImg:hover{
  box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.2),
  0px 0px 0px rgba(255, 255, 255, 0.8),
  inset 18px 18px 30px rgba(0, 0, 0, 0.1),
  inset -18px -18px 30px rgba(255, 255, 255, 1);
  transition: box-shadow .2s ease-out;
}
.neumorphism .box .boxImg:hover .tag_img{
  width: 58px;
  transition: width 0.2s ease-out;
}
</style>
