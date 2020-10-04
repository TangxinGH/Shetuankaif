<template>
    <div class="block" style="position: relative">
        <span class="demonstration">默认 Hover 指示器触发</span>
        <el-carousel height="400px" type="card">
            <el-carousel-item v-for="item in items" :key="item" style="background: #54d9e0;display: flex;justify-content: center">
                <h3 class="small">{{ item }}</h3>

                <img  sizes="(min-width: 600px) 100px, 40vw" v-bind:src="item"   alt="图片">
                <div class="block" >
                    <span class="demonstration">轮播图</span>
                    <el-image >
                        <div slot="error" class="image-slot">
                            <i class="el-icon-picture-outline"></i>
                        </div>
                    </el-image>
                </div>
            </el-carousel-item>
        </el-carousel>
        <div style="position: absolute;top:10%;left:80%;z-index: 100"  >
            log in
            <neumorphism></neumorphism>
        </div>
        <div>
            <div style="position: absolute;top:10%;left:90%;z-index: 100"  >
                sign in
                 <neumorphism></neumorphism>
            </div>
        </div>
    </div>
</template>

<script>
import Neumorphism from '@/views/neumorphism'
let imgUrl1 = require('../../assets/img/r2e391.png')
let imgUrl2 = require('../../assets/img/nexyow.jpg')
let imgUrl3 = require('../../assets/img/wallhaven-x1wroo_3840x1600.png')

export default {
  name: 'Carousel',
  components: { Neumorphism },
  data () {
    return {
      items: [imgUrl1, imgUrl2, imgUrl3]
    }
  }
}
</script>

<style scoped>

</style>
