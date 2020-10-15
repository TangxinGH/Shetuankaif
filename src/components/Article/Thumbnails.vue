<template>
  <header>
    <div class="overlay">
      <h1>Simply The Best</h1>
      <h3>Reasons for Choosing US</h3>
      <button>阅读更多</button>
    </div>
  </header>
</template>

<script>
export default {
  name: 'Thumbnails'
}
</script>

<style scoped>

header {
  text-align: center;
  width: 100%;
  height: 300px;
  background-size: cover;
  background: url('https://static01.imgkr.com/temp/acd960f3dab8425689487a8dc11ee9f5.png') fixed;
  background-size: cover;
  //position: relative;
//overflow: hidden;/*  隐藏*/ border-radius: 1% 20% 10% / 10%; /* 边界*/
}

header .overlay {
  width: 100%;
  height: 100%;
  padding: 50px;
  color: #FFF;
  text-shadow: 1px 1px 1px #333;
  /*background-image: linear-gradient( 135deg, #9f05ff69 10%, #fd5e086b 100%); 覆盖颜色 */

}

h1 {
  font-family: 'Dancing Script', cursive;
  font-size: 80px;
  margin-bottom: 15px;
}

h3, p {
  font-family: 'Open Sans', sans-serif;
  margin-bottom: 15px;
}

button {
  border: none;
  outline: none;
  padding: 10px 20px;
  margin-top: -50px;
  border-radius: 50px;
  color: #333;
  background: #fff;
  box-shadow: 0 3px 20px 0 #0000003b;
}

button:hover {
  cursor: pointer;
}
</style>
