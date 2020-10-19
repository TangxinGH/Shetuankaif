<template>
  <table width="1000" border="0" bgcolor="#fa710d" align="center" style="z-index: 9999" cellpadding="0" cellspacing="0" >
  <tbody>
  <tr>
    <td>
      <ul id="nav" style="margin: 0; padding-left: 20px; border: 0; z-index: 999999; position: relative; color: white">
        <li>
          <a   v-bind:href="env? './sichuan.html' : './sichuan'">首页</a>
        </li>
        <li>
          <a   v-bind:href="env? './history.html?ActID=1' : './history?ActID=1'">社团快讯</a>
          <ul style="margin: 0; padding: 0; border: 0;">
            <li style="margin: 0; padding: 0; border: 0;"><a target="_blank" v-bind:href="env? './history.html?NtID=1' : './history?NtID=1'">公告</a></li>
            <li style="margin: 0; padding: 0; border: 0;"><a target="_blank" v-bind:href="env? './history.html?ActID=1' : './history?ActID=1'">新闻</a></li>

          </ul>
        </li>
        <li>
          <a v-bind:href="env? './index.html' : './index'">社团风采</a>
          <ul style="margin: 0; padding: 0; border: 0;">
            <li><a href="http://jwc.glut.edu.cn/chronicle">社团联简介</a></li>
            <li>
              <a href="http://jwc.glut.edu.cn">社团简介
              </a>
            </li>
            <li><a href="http://jwc.edu.cn/">学术园地</a></li>
          </ul>
        </li>
        <li>
          <a href="http://search.jwc.edu.cn/">社团检索</a>
        </li>
        <li>
          <a href="http://lib.glut.edu.cn">资料下载</a>
        </li>
        <li>
          <a href="http://jwc.edu.cn/">规章制度</a>
        </li>
        <li style="width: 140px">
          <a v-bind:href="env ? './subscriber.html' : './subscriber'">申请社团</a>
          <ul style="margin: 0; padding: 0; border: 0; width: 140px">
            <li style="width: 140px"><a target="_blank" style="width:140px" v-bind:href="env ? './subscriber.html' : './subscriber'">非学术型社团申请</a></li>
            <li style="width: 140px"><a target="_blank" style="width:140px"
                                        v-bind:href="env ? './subscriber.html' : './subscriber'">学术型社团申请</a></li>
            <li style="width: 140px"><a target="_blank" style="width:140px" v-bind:href="env ? './subscriber.html' : './subscriber'">非学术型社团申请状态</a>
            </li>
            <li style="width: 140px"><a style="width:140px" v-bind:href="env ? './subscriber.html' : './subscriber'">学术型社团申请状态</a>
            </li>
          </ul>
        </li>

      </ul>
    </td>
  </tr>
  </tbody>
  </table>

</template>

<script>
export default {
  name: 'sichuanMenu',
  data: function () {
    return {
      env: process.env.NODE_ENV === 'production'
    }
  }
}
</script>

<style scoped>

</style>
