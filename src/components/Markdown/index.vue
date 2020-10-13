<template>
    <div :id="id">
      <editor
          :options="options"
      />
    </div>
</template>
<script>
import 'codemirror/lib/codemirror.css'
import '@toast-ui/editor/dist/toastui-editor.css'

import { Editor } from '@toast-ui/vue-editor'
// import Editor from 'tui-editor/dist/tui-editor-Editor-all.js' // all （chart...）
export default {
  components: { editor: Editor },
  props: {
    value: {
      type: String,
      default: ''
    },
    height: {
      type: Number,
      default: 1300
    },
    language: {
      type: String,
      default: 'zh_CN'
    }
  },
  data () {
    return {
      editor: '',
      id: `vue-markdown-tui.editor-${new Date().getTime()}`,
      options: {
        height: this.height,
        initialValue: this.value,
        previewStyle: 'vertical',
        language: this.language,
        useCommandShortcut: true,
        useDefaultHTMLSanitizer: true,
        usageStatistics: false, // 禁止收集数据
        hideModeSwitch: false,
        toolbarItems: ['heading', 'bold', 'italic', 'strike', 'divider', 'hr', 'quote', 'divider', 'ul', 'ol', 'task', 'indent', 'outdent', 'divider', 'table', 'image', 'link', 'divider', 'code', 'codeblock'],
        exts: [
          {
            name: 'chart',
            minWidth: 100,
            maxWidth: 600,
            minHeight: 100,
            maxHeight: 600
          },
          'scrollSync',
          'colorSyntax',
          'uml',
          'mark',
          'table'
        ]
      }
    }
  },
  watch: {
    language (val) {
      console.log(this.editor)
      this.destroyEditor()
      this.$nextTick(() => {
        this.options.language = val
        this.initEditor()
      })
    }
  },
  mounted () {
  },
  methods: {
    initEditor () {
      this.editor = new Editor({
        el: document.getElementById(this.id),
        ...this.options
      })
      this.editor.on('change', () => {
        this.$emit('input', this.editor.getValue())
      })
    },
    destroyEditor () {
      if (!this.editor) return
      this.editor.off('change')
      this.editor.remove()
    },
    getEditor () {
      return this.editor
    }
  }
}
</script>
