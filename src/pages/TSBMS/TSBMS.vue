<template>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-header
        :style="{ position: 'fixed', zIndex: 1, width: '100%' }"
    >
     <apex></apex>
    </a-layout-header>
    <a-layout>
      <a-layout-sider v-model="collapsed" collapsible
                      breakpoint="lg"
                      collapsed-width="88"
                      @collapse="onCollapse"
                      @breakpoint="onBreakpoint"
                      class="sidebar"
                      :style="{  height: '100vh', position: 'fixed', left: 0 }"
      >
<!--        SideBar -->
        <lateral></lateral>
<!--        SideBar-->
      </a-layout-sider>
      <a-layout :style="{ marginLeft: '200px' }" style="height: 200vh">
        <a-layout-content :style="{ padding: '0 50px', marginTop: '64px'}" >
          <a-breadcrumb :style="{ margin: '16px 0'}">
            <a-breadcrumb-item>User</a-breadcrumb-item>
            <a-breadcrumb-item>Bill</a-breadcrumb-item>
          </a-breadcrumb>
          <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
            Bill is a cat.
          </div>
        </a-layout-content>
<!--        footer-->
        <t-b-m-s-footer></t-b-m-s-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import TBMSFooter from '@/pages/TSBMS/Layout/TBMSFooter'
import Lateral from '@/pages/TSBMS/Layout/Lateral'
import Apex from '@/pages/TSBMS/Layout/Apex'
export default {
  components: { Apex, Lateral, TBMSFooter },
  data () {
    return {
      collapsed: false,
    }
  },
  methods: {
    onCollapse (collapsed, type) {
      console.log(collapsed, type)
    },
    onBreakpoint (broken) {
      console.log(broken)
    },
  },
}
// collapsed-width 为0时
</script>

<style scoped>
#components-layout-demo-side >>> .logo { /*深度选择器  传递给子组件 */
  height: 142px;
  background: rgb(16, 0, 254);
  margin: 16px;
}

#components-layout-demo-side >>> .logoheader {
  width: 120px;
  height: 31px;
  background: rgba(200, 35, 35, 0.2);
  margin: 16px 28px 16px 0;
  float: left;
}
.sidebar{
  margin-top: 50px;
}
</style>
