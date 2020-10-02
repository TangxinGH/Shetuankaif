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
            <div class="neumorphism centerbody"  >
                <div class="box">
                    <div class="boxImg">
                        <img class="tag_img" src="../../assets/img/kunpeng.jpg"/>
                    </div>
                    <p>录音机</p>
                </div>
            </div>
        </div>
        <div>
            <div style="position: absolute;top:10%;left:90%;z-index: 100"  >
                sign in
                <div class="neumorphism centerbody"  >
                    <div class="box">
                        <div class="boxImg">
                            <img class="tag_img" src="../../assets/img/kunpeng.jpg"/>
                        </div>
                        <p>录音机</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Carousel'
}
</script>

<style scoped>
    .centerbody{
        width: 100%;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #efeeee;
    }
    .neumorphism{
        width: 150px;
        height: 160px;
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
