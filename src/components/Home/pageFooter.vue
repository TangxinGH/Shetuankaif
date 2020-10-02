<template>
    <el-container class="topHight">
        <el-footer>pageFooter </el-footer>
    </el-container>
</template>

<script>
export default {
  name: 'pageFooter'
}
</script>

<style scoped>
    .topHight{
     margin-top: 20px;
        height:50px;
        width: 100vw;
        position:fixed;bottom:0px;left:0px;
    }
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }
    /*//箭头是特指吗*/
    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
</style>
