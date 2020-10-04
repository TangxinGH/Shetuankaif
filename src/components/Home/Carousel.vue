<template>
    <div class="block" style="position: relative">
        <span class="demonstration">默认 Hover 指示器触发</span>
        <el-carousel height="200px" type="card">
            <el-carousel-item v-for="item in 4" :key="item" style="background: #54d9e0;display: flex;justify-content: center">
                <h3 class="small">{{ item }}</h3>
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
export default {
    name: 'Carousel',
  components: { Neumorphism }
}
</script>

<style scoped>

</style>
