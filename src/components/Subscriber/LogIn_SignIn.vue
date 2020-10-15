<template>
  <a-row>
  <div class="nav">
      <ul class="sidenav">
        <li><a class="active"  v-bind:href="env? './sichuan.html' : './sichuan'">主页</a></li>
        <li><a v-bind:href="env? './history.html?ActID=1' : './history?ActID=1'">新闻</a></li>
        <li><a href="#contact">联系</a></li>
        <li><a href="#contact">关于</a></li>
        <li style="float: right;margin-right: 10vw"><a   @click="showModal">管理员登录</a></li>
        <a-modal v-model="visible" title="管理员登录" on-ok="handleOk">
          <template slot="footer">
            <a-button key="back" @click="handleCancel">
              Return
            </a-button>
          </template>
          <administrator/>
        </a-modal>
      </ul>
    </div>
      <a-col :xs="{ span: 0, offset: 0 }" :lg="{ span: 6, offset: 2 }">
<!--        <circle-a-p-ps/>-->
      </a-col>
      <a-col :xs="{ span: 11, offset: 1 }" :lg="{ span: 6, offset: 2 }">
        <FromBody></FromBody>
      </a-col>
    </a-row>
</template>

<script>
import CircleAPPs from '@/components/Subscriber/circleAPPs'
import FromBody from '@/components/Subscriber/FormBody'
import { Row, Col } from 'ant-design-vue'
import Vue from 'vue'
import 'ant-design-vue/dist/antd.css'
import Administrator from '@/components/Subscriber/administrator'
Vue.use(Row)
Vue.use(Col)
export default {
  name: 'LogIn_SignIn',
  components: {
    Administrator,
    FromBody,
    CircleAPPs
  },
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

<style lang="less" scoped>
.nav {
  ul.sidenav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 25%;
    background-color: #f1f1f1;
    height: 100%;
    overflow: auto;
  }

  ul.sidenav li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
  }

  ul.sidenav li a.active {
    background-color: #4CAF50;
    color: white;
  }

  ul.sidenav li a:hover:not(.active) {
    background-color: #555;
    color: white;
  }

  ul.sidenav {
    width: 100%;
    height: auto;
  }

  ul.sidenav li a {
    float: left;
    padding: 15px;
  }
}
</style>
