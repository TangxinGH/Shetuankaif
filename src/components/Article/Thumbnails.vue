<template>
  <div class="block">
    <el-row :gutter="20">
      <el-col :xs="{span:24,offset:0}" :lg="{ span: 16, offset: 4}" >
        <div class="grid-content bg-purple"></div>
      <span class="demonstration">自定义</span>
      <el-image :src="Skyline" class="thumbnails">
        <div slot="placeholder" class="image-slot">
          加载中<span class="dot">...</span>
        </div>
      </el-image>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
    name: "Thumbnails",
    data() {
        return {
            Skyline: 'https://static01.imgkr.com/temp/acd960f3dab8425689487a8dc11ee9f5.png'
        }
    }
}
</script>

<style scoped>
.thumbnails{
  height: 30vh;

}
.block{
  display: flex;
  justify-content: center;
}
</style>
