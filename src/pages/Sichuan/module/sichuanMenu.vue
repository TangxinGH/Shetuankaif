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
              <a  @click="showModal">社团简介
                <a-modal v-model="visible" title="管理员登录" on-ok="handleOk">
                  <template slot="footer">
                    <a-button key="back" @click="handleCancel">
                      Return
                    </a-button>
                  </template>
                  <features-page></features-page>
                </a-modal>
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
import FeaturesPage from '@/components/Home/FeaturesPage'
export default {
  name: 'sichuanMenu',
  components: { FeaturesPage },
  data: function () {
    return {
      env: process.env.NODE_ENV === 'production',
      loading: false,
      visible: false

    }
  },

  methods: {
    showModal () {
      this.visible = true
    },
    handleOk (e) {
      this.loading = true
      setTimeout(() => {
        this.visible = false
        this.loading = false
      }, 3000)
    },
    handleCancel (e) {
      this.visible = false
    }
  }
}
</script>

<style scoped>

</style>
