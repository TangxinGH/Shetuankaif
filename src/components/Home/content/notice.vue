<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>公告</span>
            <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
            {{'列表内容 ' + o }}
            <div>
                <span>时间</span>
                <el-divider direction="vertical"></el-divider>
                <span>标题  </span>
                <el-divider direction="vertical"></el-divider>
                <span>作者</span>
            </div>
        </div>
    </el-card>
</template>

<script>
export default {
  name: 'notice'
}
</script>

<style scoped>
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }
</style>
