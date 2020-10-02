<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="3" :offset="2"><div class="grid-content bg-purple"><img style="height: 100px" src="../../assets/img/kunpeng.jpg">LOGO</div></el-col>
            <el-col :span="6" :offset="1" class="hidden-xs-only"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="6" ><div class="grid-content bg-purple">
                <el-row type="flex" class="row-bg" justify="end">
                    <el-col :span="6"><div class="grid-content bg-purple-light">导航</div></el-col>
                    <el-col :span="6"><div class="grid-content bg-purple-blue">导航</div></el-col>
                    <el-col :span="6"><div class="grid-content bg-purple-light">导航</div></el-col>
                </el-row>
            </div></el-col>
            <el-col :span="6" ><div class="grid-content bg-purple">
                <el-row type="flex" class="row-bg" justify="start">
                    <el-col :span="6"><div class="grid-content bg-purple-light">搜索</div></el-col>
                    <el-col :span="6" :offset="1"><div class="grid-content bg-purple-blue">搜索图标</div></el-col>
                </el-row>
            </div></el-col>
        </el-row>
    </div>
</template>

<script>
//Element 额外提供了一系列类名，用于在某些条件下隐藏元素。
// 这些类名可以添加在任何 DOM 元素或自定义组件上。
// 如果需要，请自行引入以下文件：
import 'element-ui/lib/theme-chalk/display.css'

export default {
    name: 'navigation'
}
</script>

<style scoped>
    .bg-purple-blue{
        background: #99a9bf;
    }
    .gutter-row{
        background: #54d9e0;
    }
    .el-col {
        border-radius: 4px;
    }
    .bg-purple-dark {
        background: #99a9bf;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }
</style>
