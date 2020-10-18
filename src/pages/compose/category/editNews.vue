<template>
  <a-form :form="form" @submit="handleSubmit">
    <a-tag color="#108ee9">文章编辑</a-tag>
    <a-form-item :label-col="labelCol" :wrapper-col="wrapperColForSelect" label="文章分类">
      <a-select
          style="width: 100%"
          v-decorator="['category_id',{initialValue:article.article_id,rules: [{ required: true, message: '请选择文章分类' }]}]"
      >
        <a-select-option value="0">公告</a-select-option>
        <a-select-option v-for="(key,cate) in cate_list" v-bind:key="key"  :value="cate.category_id" >{{ cate.category_name }}</a-select-option>
      </a-select>
    </a-form-item>
    <a-form-item :label-col="labelCol" :wrapper-col="wrapperColForSelect" label="文章标题">
      <a-input
          v-decorator="['article_title',{initialValue:article.article_title,rules: [{ required: true, message: '请填写文章名称' }]}]"/>
    </a-form-item>
    <a-form-item :label-col="labelCol" :wrapper-col="wrapperColForSelect" label="关键词" help="关键词用英文逗号','分隔">
      <a-input
          v-decorator="['keywords',{initialValue:article.keywords,rules: [{ required: true, message: '请填写关键词' }]}]"/>
    </a-form-item>
    <a-form-item :label-col="labelCol" :wrapper-col="wrapperColForSelect" label="文章摘要">
<!--      id 重复了-->
      <a-textarea
          v-decorator="['keyword',{initialValue:article.keywords,rules: [{ required: false, message: '请填写关键词' }]}]"
          autoSize/>
    </a-form-item>
    <a-form-item :label-col="labelCol" :wrapper-col="wrapperColForSelect" label="文章插图">
      <a-upload
          name="article_pic"
          listType="picture-card"
          class="avatar-uploader"
          :showUploadList="false"
          action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
          :beforeUpload="beforeUpload"
          @change="handleChange"
          v-decorator="['article_pic']"
      >
        <img v-if="imageUrl" :src="imageUrl" alt="avatar"/>
        <div v-else>
          <a-icon :type="loading ? 'loading' : 'plus'"/>
          <div class="ant-upload-text">选择头像</div>
        </div>
      </a-upload>
    </a-form-item>
    <a-form-item :label-col="labelCol" :wrapper-col="wrapperCol" label="文章内容">
      <!--使用 Tinymce.vue 组件-->
      <tinymce_editor v-model="msg"
                      :disabled="disabled"
                      @onClick="onClick"
                      ref="editor">

      </tinymce_editor>
    </a-form-item>
    <a-form-item :label-col="labelCol" :wrapper-col="{ span: 8, offset: 16 }">
            <a-button type="primary" html-type="submit" class="login-form-button" style="margin-top: 8%;">
              保存发布
            </a-button>
          <a-button type="danger" class="login-form-button" @click="resetFields" style="margin-left: 50px">
            重置
          </a-button>
    </a-form-item>
  </a-form>
</template>
<script>
import TinyMce from '@/components/EditEssay/Tinymce'
import moment from 'moment'

function getBase64 (img, callback) {
  const reader = new FileReader()
  reader.addEventListener('load', () => callback(reader.result))
  reader.readAsDataURL(img)
}
export default {
  name: 'MenuEdit',
  components: {
    tinymce_editor: TinyMce
  },
  data: function () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      // article_id: this.$route.query.article_id,
      article: [],
      cate_list: [],
      imageUrl: '',
      head_pic: '',
      labelCol: {
        xs: { span: 24 },
        sm: { span: 5 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 18 }
      },
      wrapperColForSelect: {
        xs: { span: 24 },
        sm: { span: 7 },
        lg: { span: 9 }
      },
      disabled: false,
      msg: '欢迎来到全新编辑器'
    }
  },
  // created () {
  //   EditArticle({
  //     article_id: this.article_id
  //   }).then((response) => {
  //     if (response.data.code == 1) {
  //       this.article = response.data.data.article
  //       this.cate_list = response.data.data.cate_list
  //       this.imageUrl = response.data.data.article.article_pic
  //     } else {
  //       this.msg = response.data.msg
  //       this.openNotification()
  //     }
  //   }).catch((err) => {
  //     console.log(err)
  //   })
  // },
  methods: {
    openNotification () {
      this.$notification.open({
        message: '提醒框',
        description: this.msg
      })
    },

    handleSubmit (e) {
      e.preventDefault()

      console.log(this.$refs.editor.myValue)

      this.form.validateFields((errors, values) => {
        if (errors) {
          console.log(errors)
        } else {
          values.article_id = this.article_id
          values.article_pic = this.article_pic
          console.log('表单值')
          console.log(values)
          this.postSubmit(values)
        }
      })
    },
    resetFields () {
      this.form.resetFields()
    },
    postSubmit (param) {
      let data = {
          actTitle: param.article_title,
          actAuthor: 'XXX',
          actPublishTime: moment().format('YYYY-MM-DD'),
          actContent: this.$refs.editor.myValue,
          actAttachment: '',
          actAuthorID: 1248545

      }
      this.$axios.post('/api/addAnActivity', data).then(res => {
        console.log('发布活动')
        console.log(res)
        this.$message.info(' 活动发送成功')
        // res.data.actID 跳转
      }).catch(err => {
        console.log(err)
        this.$message.error(' 活动发送失败')
      })
    },
    handleChange (info) {
      if (info.file.status === 'uploading') {
        this.loading = true
        return
      }
      if (info.file.status === 'done') {
        this.article_pic = info.file.response.thumbUrl
        // Get this url from response in real world.
        getBase64(info.file.originFileObj, (imageUrl) => {
          this.imageUrl = imageUrl
          this.loading = false
        })
      } else if (info.file.status === 'error') {
        this.$message.error('上传失败', 2)
      }
    },
    beforeUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      if (!isJPG) {
        this.$message.error('You can only upload JPG file!')
      }
      const isLt2M = file.size / 1024 / 1024 < 2
      if (!isLt2M) {
        this.$message.error('Image must smaller than 2MB!')
      }
      return isJPG && isLt2M
    },
    // 鼠标单击的事件
    onClick (e, editor) {
      console.log('Element clicked')
      console.log(e)
      console.log(editor)
    }
  }
}
</script>

<style scoped>

</style>
