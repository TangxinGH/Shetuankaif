const path = require('path')
const glob = require('glob')
// let mock = require('./src/mock/index.json');
var BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin

module.exports = {
  lintOnSave: false,
  // publicPath: process.env.NODE_ENV === 'production' ? 'https://www.baidu.com/' : '/', // baseUrl 从 Vue CLI 3.3 起已弃用，请使用publicPath。
  publicPath: '/',
  // outputDir: 'E:\\server\\nginx-1.18.0\\html',
  productionSourceMap: false,
  pages: {
    index: {
      entry: 'src/pages/index/index.js', // entry for the public page
      template: 'public/index.html', // source template
      filename: 'index.html', // output as dist/*
      chunks: ['chunk-vendors', 'chunk-common', 'index'] //   // 提取出来的通用 chunk 和 vendor chunk。
    },
    article: {
      entry: 'src/pages/article/article.js',
      template: 'public/index.html',
      filename: 'article.html'
    },
    compose: {
      entry: 'src/pages/compose/editEssay.js',
      template: 'src/pages/compose/compose.html',
      filename: 'compose.html'
    },
    // devtool: 'source-map', // 调试修改source map属性，从cheap-module-eval-source-map改为source-map
    subscriber: {
      entry: 'src/pages/subscriber/subscriber.js',
      template: 'public/index.html',
      filename: 'subscriber.html'
    },
    tsbms: {
      entry: 'src/pages/TSBMS/TSBMS.js',
      template: 'public/index.html',
      filename: 'tsbms.html',
      chunks: ['chunk-vendors', 'chunk-common', 'tsbms']
    },
    history: {
      entry: 'src/pages/history/history.js',
      template: 'public/index.html',
      filename: 'history.html',
      chunks: ['chunk-vendors', 'chunk-common', 'history']
    },
    sichuan: {
      entry: 'src/pages/Sichuan/Sichuan.js',
      template: 'src/pages/Sichuan/sichuan.html',
      filename: 'sichuan.html',
      chunks: ['chunk-vendors', 'chunk-common', 'sichuan']
    }
  },
  configureWebpack: config => {
    if (process.env.NODE_ENV === 'development') {
      config.devtool = 'source-map' // webstorm 调试用的
    }
  },
  devServer: {
    index: '/',
    // open: false, // process.platform === 'darwin', 根据平台打开浏览器？？
    host: '',
    port: 9527,
    https: false,
    historyApiFallback: {
      rewrites: [
        // shows views/landing.html as the landing page
        { from: /^\/$/, to: '/index.html' },
        // shows views/subpage.html for all routes starting with /subpage
        { from: /^\/article/, to: '/article.html' }, // 这东西有效？还真有效
        { from: /^\/compose/, to: '/compose.html' },
        { from: /^\/subscriber/, to: '/subscriber.html' },
        { from: /^\/tsbms/, to: '/tsbms.html' },
        { from: /^\/history/, to: '/history.html' },
        { from: /^\/sichuan/, to: '/sichuan.html' }
      ]
    },
    proxy: {
      '^/api': {
        target: 'http://121.37.129.14:3000', // 代理地址，这里设置的地址会代替axios中设置的baseURL
        changeOrigin: true, // 如果接口跨域，需要进行这个参数配置
        ws: true, // proxy websockets
        secure: false,
        logLevel: 'debug',
        // pathRewrite方法重写url
        // pathRewrite: {
        // '^/api': '/'
        // pathRewrite: {'^/api': '/'}  //重写之后url为 http://192.168.1.16:8085/xxxx
        pathRewrite: { '^/api': '/mock/11/api' } // 重写之后url为 http://192.168.1.16:8085/api/xxxx
        // }
      }
    }
  },
  chainWebpack: config => {
    config.module
      .rule('images')
      .use('url-loader')
      .loader('url-loader')
      .tap(options => {
        // 修改它的选项...
        options.limit = 100
        return options
      })
    // Object.keys(pages).forEach(entryName => {
    //   config.plugins.delete(`prefetch-${entryName}`)
    // })
    if (process.env.NODE_ENV === 'production') {
      config.plugin('extract-css').tap(() => [{
        path: path.join(__dirname, './dist'),
        filename: 'css/[name].[contenthash:8].css'
      }])
    }
  }
}
// 链接：https://juejin.im/post/6844903733856305165
