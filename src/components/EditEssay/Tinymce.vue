<template>
  <div class="tinymce-editor">
    <Editor v-model="myValue"
            :init="init"
            :disabled="disabled"
            @onClick="onClick">
    </Editor>
  </div>
</template>
<!--我们将其再封装一下，这个是封装的方便自己在其他组件中使用-->
<script>
import tinymce from 'tinymce/tinymce'
import Editor from '@tinymce/tinymce-vue' // 这是个插件是要用的。
import 'tinymce/themes/silver'
import 'tinymce/plugins/image'
import 'tinymce/plugins/media'
import 'tinymce/plugins/table'
import 'tinymce/plugins/lists'
import 'tinymce/plugins/contextmenu'
import 'tinymce/plugins/wordcount'
import 'tinymce/plugins/colorpicker'
import 'tinymce/plugins/textcolor'
import 'tinymce/icons/default' // 图标？？？
export default {
  name: 'Tinymce.vue',
  components: {
    Editor
  },
  props: {
    // 传入一个value，使组件支持v-model绑定
    value: {
      type: String,
      default: ''
    },
    disabled: {
      type: Boolean,
      default: false
    },
    plugins: {
      type: [String, Array],
      // 分析发现，text color、context menu、color picker 插件 现在内置到核心编辑器中， 请将其从编辑器配置中删除
      default: 'lists image media table  wordcount '
    },
    toolbar: {
      type: [String, Array],
      default: 'undo redo | formatselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | lists image media table | removeformat'
    }
  },
  data () {
    return {
      // 初始化配置
      init: {
        language_url: '/tinymce/langs/zh_CN.js', // 语言包的路径
        language: 'zh_CN', // 语言
        skin_url: '/tinymce/skins/ui/oxide', // skin路径
        content_css: '/tinymce/skins/content/default/content.css',
        height: 800, // 编辑器高度
        plugins: this.plugins,
        toolbar: this.toolbar,
        branding: false, // 是否禁用“Powered by TinyMCE”
        menubar: false, // 顶部菜单栏显示
        // 此处为图片上传处理函数，这个直接用了base64的图片形式上传图片，
        // 如需ajax上传可参考 https://www.tiny.cloud/docs/configure/file-image-upload/#images_upload_handler
        images_upload_handler: (blobInfo, success, failure) => {
          let param = new FormData() // 创建form对象
          param.append('image', blobInfo.blob())// 通过append向form对象添加数据
          // console.log(param.get('file')) // FormData私有类对象，访问不到，可以通过get判断值是否传进去
          let config = { headers: { 'Content-Type': 'multipart/form-data' } } // 添加请求头

          this.$axios.post('https://api.imgbb.com/1/upload?key=4cf8fa68d0e094302371bfb88f67fdbb', param, config).then(res => {
            success(res.data.data.url)
            this.$message.success(' 图片上传成功')
          }).catch(err => {
            failure(err)
          })
          // const img = 'data:image/jpeg;base64,' + blobInfo.base64()
          // success(img)
        }
      },
      myValue: this.value
    }
  },
  mounted () {
    tinymce.init({})
  },
  methods: {
    // 添加相关的事件，可用的事件参照文档=> https://github.com/tinymce/tinymce-vue => All available events
    // 需要什么事件可以自己增加
    onClick (e) {
      this.$emit('onClick', e, tinymce)
    },
    // 可以添加一些自己的自定义事件，如清空内容
    clear () {
      this.myValue = ''
    }
  },
  watch: {
    value (newValue) {
      this.myValue = newValue
    },
    myValue (newValue) {
      this.$emit('input', newValue)
    }
  }
}

</script>

<style scoped>

</style>
