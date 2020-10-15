<template>
  <td>
    <table width="100%" border="0" id="tbgg" cellspacing="0" cellpadding="0" style="display: none;">

      <tbody>
      <tr>
        <td colspan="2" align="center" class="font4"><a target="_blank" style="color: #F70B19"
                                                        v-bind:href="env ? '/article.html?ntID='+ n_one.ntID : '/article?ntID='+n_one.ntID" >
          {{ n_one.ntTitle }}</a>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ n_one.atContent }} ...<a
            target="_blank" style="color: #d0000e"
            v-bind:href="env ? '/article.html?ntID='+ n_one.ntID : '/article?ntID='+n_one.ntID">详细&gt;&gt;</a>
        </td>
      </tr>
      <tr>
        <notice v-on:parentFunctionNotice="notice_data_One"></notice>
      </tr>

      </tbody>
    </table>

    <table width="100%" border="0" id="tbst" style="display: table;" cellspacing="0" cellpadding="0">

      <tbody>
      <tr>
        <td colspan="2" align="center" class="font4"><a target="_blank" style="color: #F70B19"
                                                        v-bind:href="env ? '/article.html?actID='+ a_one.actID : '/article?actID='+a_one.actID" >[社联新闻]
         {{ a_one.actTitle }} </a></td>
      </tr>
      <tr>
        <td colspan="2" align="left">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          {{ a_one.actContent }}...<a
            target="_blank" style="color: #d0000e"
            v-bind:href="env ? '/article.html?actID='+ a_one.actID : '/article?actID='+a_one.actID" >详细&gt;&gt;</a>
        </td>
      </tr>
     <news v-on:parentFunctionNews="activity_data_One"/>
      </tbody>
    </table>
  </td>
</template>

<script>
import notice from '@/components/Home/content/notice'
import News from '@/components/Home/content/news'
export default {
  name: 'sichuanContent',
  components: {
    News,
    notice
  },
  data: function () {
    return {
      a_one: [],
      n_one: [],
      env: process.env.NODE_ENV === 'production'
    }
  },
  mounted () {
    document.getElementById('slxw').addEventListener('click', function () {
      document.getElementById('slsrc').setAttribute('href', this.env ? './history.html?ntID=1' : './history?ntID=1')
    })
    document.getElementById('slgg').addEventListener('click', function () {
      document.getElementById('slsrc').setAttribute('href', this.env ? './history.html?actID=1' : './history?actID=1')
    })
  },
  methods: {
    activity_data_One: function (msg) {
      this.a_one = Object.assign(msg)
      this.a_one.actContent = this.a_one.actContent.slice(1, 500)
    },
    notice_data_One: function (msg) {
      this.n_one = Object.assign(msg)
      this.n_one.ntContent = this.n_one.ntContent.slice(1, 500)
    }
  }
}
</script>

<style scoped>

</style>
