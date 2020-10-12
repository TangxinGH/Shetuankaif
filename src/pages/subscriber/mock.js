import Mock from 'mockjs'

const data = {
  code: '@integer(20, 23)'
}

// Mock.mock('/api/login?Sno=869876&Password=87987979', 'post', data)
// 记录数据模板。当拦截到匹配 rurl 和 rtype 的 Ajax 请求时，将根据数据模板 template 生成模拟数据，并作为响应数据返回。
//
// // 注册模拟数据
// const data1 = {
//   code: '@integer(200, 202)'
// }
// Mock.mock('/api/register', 'post', data1)
// //   function (options) { //不要少了斜杠
// //     window.console.log("这是mock/register/"+options);
// //    window.console.log( options.body.username);
// //    window.console.log(options.body.password);
// //    window.console.log(options.body.role);
// // return data1;
// // })
//
// // 登录时候的数据，单引号才会解析数据！！！
//
// const data2 = {
//   code: '@integer(100, 103)',
//   role: '@integer(300, 303)'
// }
// Mock.mock('/api/login', 'post', data2)
// // function (options) { //不要少了斜杠
// //
// //   var json=JSON.parse(options.body);//不然直接取会显示undefined！！！！！
// //   window.console.log("这是mock/login:"+json);
// //   window.console.log( "这是mock/login/username:"+json.username);
// //   window.console.log("这是mock/login/password:"+json.password);
// //
// //
// //   return data2;
// // })//作为函数的返回并没有改变，只能写死,就测试的时候用一下而已
//
// // 请求书单
// const data3 = [{
//   name: '@ctitle(3, 8)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
//
// }, {
//   name: '@ctitle(3, 5)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
// },
// {
//   name: '@ctitle(3, 5)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
// }, {
//   name: '@ctitle(3, 8)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
// }, {
//   name: '@ctitle(3, 5)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
// }, {
//   name: '@ctitle(3, 5)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
// }, {
//   name: '@ctitle(3, 5)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
// }, {
//   name: '@ctitle(3, 5)',
//   ISBN: '@guid',
//   'id|1-5': '@string',
//   price: '@float(10, 200, 3, 5)',
//   count: '@integer(10, 203)'
// }
// ]
//
// Mock.mock('/api/buy/textbook', 'post', data3)
// // Mock.setup({
// //   timeout: '60-100' // 表示响应时间介于 200 和 600 毫秒之间，默认值是'10-100'。全局？
// // })
//
// // 提交书单的返回码
// const data4 = {
//   code: '@integer(400, 401)'
// }
// Mock.mock('/api/buy/submit/textbook', data4)
//
// // 查询已购书单
// const data5 = [
//   {
//     status: '@integer(500, 502)',
//     date: '@date()',
//     bookItem: data3
//   },
//   {
//     status: '@integer(500, 502)',
//     date: '@date()',
//     bookItem: data3
//   },
//   {
//     status: '@integer(500, 502)',
//     date: '@date()',
//     bookItem: data3
//   }
// ]
// Mock.mock('/api/query/textbook', 'post', data5)
//
// // 发票数据
//
// const data6 = {
//   machinenum: '@natural',
//   ititle: '@ctitle(2, 5)',
//   icode: '@natural(11160, 999100)',
//   inum: '@natural',
//   iyear: '@date("yyyy")',
//   imonth: '@date("MM")',
//   idate: '@date("dd")',
//   icheckout: '@natural(11160, 999100)',
//   ibuyname: '@ctitle(3, 7)',
//   ibuydistinguish: '@string("upper", 10)',
//   ibuycontact: '@email()',
//   ibuybank: '@county(true)',
//   imongey: '@natural(1160, 9100)',
//   ipaid: '@float(60, 900)',
//   ibignum: '@float(900, 1900)',
//   ismallnum: '@float(960, 9900)',
//   isellname: '@csentence(5)',
//   iselldistinguish: '@natural',
//   isellcontact: '@email()',
//   isellbank: '@csentence(5)',
//   iremarks: '@ctitle(10)',
//   ipayee: '@cname',
//   ireviewer: '@cname',
//   iissuer: '@cname',
//   iseller: '@cname'
// }
// Mock.mock('/api/query/textbook/invoice', 'post', data6)
//
// // 查询需要审核的书单
// const data7 = [
//   {
//     orderNumber: '@natural',
//     date: '@date()',
//     status: '@integer(500, 502)',
//     orderContent: data3
//   },
//   {
//     orderNumber: '@natural',
//     date: '@date()',
//     status: '@integer(500, 502)',
//     orderContent: data3
//   },
//   {
//     orderNumber: '@natural',
//     date: '@date()',
//     status: '@integer(500, 502)',
//     orderContent: data3
//   },
//   {
//     orderNumber: '@natural',
//     date: '@date()',
//     status: '@integer(500, 502)',
//     orderContent: data3
//   },
//   {
//     orderNumber: '@natural',
//     date: '@date()',
//     status: '@integer(500, 502)',
//     orderContent: data3
//   },
//   {
//     orderNumber: '@natural',
//     date: '@date()',
//     status: '@integer(500, 502)',
//     orderContent: data3
//   }
// ]
// Mock.mock('/api/audit/query/textbook', 'post', data7)
//
// // 提交需要审核的订单
// const data8 = {
//   orderNumber: '@natural',
//   'status|1': [600, 601, 602, 603, 600, 600, 600]
// //    从数组中随机选一个
// }
// Mock.mock('/api/audit/submit/textbookstatus', 'post', data8)
//
// // 查询缺书单
// const data9 = {
//
// }
// Mock.mock('/api/purchase/textbook', 'post', data3)
//
// const data10 = {
//   code: '@integer(700, 702)'
// }
// Mock.mock('/api/purchase/updata/book', data10)
//
export default Mock
//
// // https://github.com/nuysoft/Mock/wiki/Mock.mock()
// // 如果是GET请求，那么要从options.url里面拿，然后自己解析出来；
// // 如果是普通的POST请求，那么要从options.body里面拿，然后自己解析类似a=1&b=2这种格式；
// // 如果参数是JSON格式并且是POST，那么要从options.body里面拿，然后JSON.parse()再获取；
