<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>社团简介</span>
            <el-button style="float: right; padding: 3px 0" type="text">了解更多</el-button>
        </div>
        <div class="text item">
            kunpeng 社团是一个心理素质拓展活动社团
          <p/>
          我们是桂林理工大学最好玩的社团，我们是最爱玩，最会玩的素拓人。定期组织素质拓展活动
<p/>
          <P>扫码关注  <b>  加入我们</b></P>
        </div>
    </el-card>
</template>

<script>
export default {
  name: 'Introduction'
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
