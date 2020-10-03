<template>
  <div>

    <div id="tabs3">
      <ul>
        <li><a href="#tabs-1" title="">Tab 1</a></li>
        <li><a href="#tabs-2" title="">Tab 2</a></li>
        <li><a href="#tabs-3" title="">Tab 3</a></li>
      </ul>

      <div id="tabs_container">

        <div id="tabs-1">
          <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus.</p><p>Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
        </div>

        <div id="tabs-2">
          <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor.</p>

        </div>

        <div id="tabs-3">
          <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem.</p><p> Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales.</p>
        </div>

      </div><!--End tabs container-->

    </div><!--End tabs-->

    <a-form-model-item label="Activity zone" :label-col="{ span: 4,offset: 6 }" >
      <a-select  placeholder="please select your zone"
                 label-in-value
                 :default-value="{ key: 'lucy' }"
                 :wrapperCol="{span: 8}"
                 style="width: 320px"
                 @change="handleChange"
      >
        <a-select-option value="editNotice">
          Jack (100)
        </a-select-option>
        <a-select-option value="editNews">
          Lucy (101)
        </a-select-option>
      </a-select>
    </a-form-model-item>
    <router-link to="editNews">
      <a-button type="primary" icon="search">
        news
      </a-button>
    </router-link>
    <router-link to="editNotice">
      <a-button type="primary" icon="search">
        notices
      </a-button>
    </router-link>
    <router-view></router-view>
  </div>

</template>

<script>
import urljs from 'urijs'
import $ from 'jquery'
import documentRead from '../../assets/tabs/tabs'
documentRead()

export default {
  name: 'editEssay',
  data: function () {
    return {
    }
  },
  methods: {
    handleChange (value) {
      if (value === 'editNotice') {
        this.$router.push({ path: '/editNotice' })
      } else {
        this.$router.push({ path: '/editNews' })
      }

      console.log(value) // { key: "lucy", label: "Lucy (101)" }
    },
    funurl: function () {
      console.log('url sss' + 'window.location.href:' + window.location.href + 'this.$route.params:' + this.$route.params)
      const url = window.location.href // 获取当前url
      const dzUrl = url.split('#')[0]// 获取#/之前的字符串
      let cs = dzUrl.split('?')[1]// 获取?之后的参数字符串
      const csArr = cs.split('&')// 参数字符串分割为数组
      cs = {}
      for (let i = 0; i < csArr.length; i++) { // 遍历数组，拿到json对象
        cs[csArr[i].split('=')[0]] = csArr[i].split('=')[1]
      }
      this.id = cs.id // 这样就拿到了参数中的数据
      /* this.$router.push({name:"B",query:{
同页面内
     Id : this.tId ,

    ...

}}) */
      // 作者：勤能补拙的笨小孩
      // 链接：https://juejin.im/post/6844903933735862286
      //     来源：掘金
      // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
  }
}
</script>

<style scoped>
@import '../../assets/tabs/css/progression.css'; /*这个分号一定要写，要不会报错 */
@import '../../assets/tabs/css/reset-min.css';
@import '../../assets/tabs/css/style.css';
</style>
