<template>
  <td>
    <table width="100%" border="0" id="tbgg" cellspacing="0" cellpadding="0" style="display: none;">

      <tbody>
      <tr>
        <td colspan="2" align="center" class="font4"><a target="_blank" style="color: #F70B19"
                                                        v-bind:href="env ? '/article.html?NtID='+ n_one.NtID : '/article?NtID='+n_one.NtID" >
          {{ n_one.Nt_Title }}</a>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ n_one.Nt_Content }} ...<a
            target="_blank" style="color: #d0000e"
            v-bind:href="env ? '/article.html?NtID='+ n_one.NtID : '/article?NtID='+n_one.NtID">详细&gt;&gt;</a>
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
                                                        v-bind:href="env ? '/article.html?ActID='+ a_one.ActID : '/article?ActID='+a_one.ActID" >[社联新闻]
         {{ a_one.Act_Title }} </a></td>
      </tr>
      <tr>
        <td colspan="2" align="left">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          {{ a_one.Act_Content }}...<a
            target="_blank" style="color: #d0000e"
            v-bind:href="env ? '/article.html?ActID='+ a_one.ActID : '/article?ActID='+a_one.ActID" >详细&gt;&gt;</a>
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
      document.getElementById('slsrc').setAttribute('href', this.env ? './history.html?NtID=1' : './history?NtID=1')
    })
    document.getElementById('slgg').addEventListener('click', function () {
      document.getElementById('slsrc').setAttribute('href', this.env ? './history.html?ActID=1' : './history?ActID=1')
    })
  },
  methods: {
    activity_data_One: function (msg) {
      this.a_one = Object.assign(msg)
      this.a_one.Act_Content = this.a_one.Act_Content.slice(1, 500)
    },
    notice_data_One: function (msg) {
      this.n_one = Object.assign(msg)
      this.n_one.Nt_Content = this.n_one.Nt_Content.slice(1, 500)
    }
  }
}
</script>

<style scoped>

</style>
