import $ from 'jquery'
function documentRead () {
  $(document).ready(function ($) {
    $('#tabs3').tabulous({
      effect: 'scaleUp'
    })
  })

  /*!
 * strength.js
 * Original author: @aaronlumsden
 * Further changes, comments: @aaronlumsden
 * Licensed under the MIT license
 */
  ;(function ($, window, document, undefined) {
    const pluginName = 'tabulous'
    const defaults = {
      effect: 'scale'
    }

    // $('<style>body { background-color: red; color: white; }</style>').appendTo('head');

    function Plugin (element, options) {
      this.element = element
      this.$elem = $(this.element)
      this.options = $.extend({}, defaults, options)
      this._defaults = defaults
      this._name = pluginName
      this.init()
    }

    Plugin.prototype = {

      init: function () {
        const links = this.$elem.find('a')
        const firstchild = this.$elem.find('li:first-child').find('a')
        const lastchild = this.$elem.find('li:last-child').after('<span class="tabulousclear"></span>')

        if (this.options.effect == 'scaleUp') {
          this.$elem.find('div').not(':first').not(':nth-child(1)').addClass('hidescaleup')
        }

        const firstdiv = this.$elem.find('#tabs_container')
        const firstdivheight = firstdiv.find('div:first').height()

        const alldivs = this.$elem.find('div:first').find('div')

        alldivs.css({ position: 'absolute', top: '40px' })

        firstdiv.css('height', firstdivheight + 'px')

        firstchild.addClass('tabulous_active')

        links.bind('click', { myOptions: this.options }, function (e) {
          e.preventDefault()

          const $options = e.data.myOptions
          const effect = $options.effect

          const mythis = $(this)
          const thisform = mythis.parent().parent().parent()
          const thislink = mythis.attr('href')

          firstdiv.addClass('transition')

          links.removeClass('tabulous_active')
          mythis.addClass('tabulous_active')
          const thisdivwidth = thisform.find('div' + thislink).height()

          if (effect == 'scaleUp') {
            alldivs.removeClass('showscaleup').addClass('make_transist').addClass('hidescaleup')
            thisform.find('div' + thislink).addClass('make_transist').addClass('showscaleup')
          }

          firstdiv.css('height', thisdivwidth + 'px')
        })
      },

      yourOtherFunction: function (el, options) {
      // some logic
      }
    }

    // A really lightweight plugin wrapper around the constructor,
    // preventing against multiple instantiations
    $.fn[pluginName] = function (options) {
      return this.each(function () {
        new Plugin(this, options)
      })
    }
  })($, window, document)
}

export default function () {
  documentRead()
}
/*
* vue如何导入外部js文件（es6）
* 也许大家都是使用习惯了es5的写法喜欢直接用《Script》标签倒入js文件，但是很是可惜，这写法。在es6，或则说vue环境下不支持
*/
