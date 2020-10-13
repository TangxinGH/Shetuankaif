# kunpeng2

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your unit tests
```
npm run test:unit
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).


1. 先不管样式先

HTML <input> pattern Attribute
```git
Browser
In a browser, you can use the URLSearchParams API as follows:

const params = new URLSearchParams();
params.append('param1', 'value1');
params.append('param2', 'value2');
axios.post('/foo', params);
Note that URLSearchParams is not supported by all browsers (see caniuse.com), but self is a polyfill available (make sure to polyfill the global environment).

Alternatively, you can encode data using the qs library:

const qs = require('qs');
axios.post('/foo', qs.stringify({ 'bar': 123 }));
Or in another way (ES6),

import qs from 'qs';
const data = { 'bar': 123 };
const options = {
  method: 'POST',
  headers: { 'content-type': 'application/x-www-form-urlencoded' },
  data: qs.stringify(data),
  url,
};
axios(options);
```

![image-20201012150539316](https://img.vim-cn.com/7c/0ad4a1ac0cf6d1a5b2eea51b282b1e8c87f2ab.png)

```javascript
 //text
            'paragraph': Random.paragraph( 3, 7 ), // 随机生成一段文本。
            'cparagraph': Random.cparagraph( 1, 3 ), // 随机生成一段中文文本。
            'sentence': Random.sentence( 1, 3 ), // 随机生成一个句子，第一个单词的首字母大写。
            'csentence': Random.csentence( 1, 3 ),// 随机生成一段中文文本。
            'word': Random.word( 1, 3 ),// 随机生成一个单词。
            'cword': Random.cword('零一二三四五六七八九十', 10,15),//生成中文10到15个
            'title': Random.title( 3, 5 ), // 随机生成一句标题，其中每个单词的首字母大写。
            'ctitle': Random.ctitle( 3, 7 ), // 随机生成一句中文标题。

            //name
            'first': Random.first(),// 随机生成一个常见的英文名。
            'last': Random.last(),// 随机生成一个常见的英文姓。
            'name': Random.name(),// 随机生成一个常见的英文姓名。
            'cfirst': Random.cfirst(),// 随机生成一个常见的中文名。
            'clast': Random.clast(), // 随机生成一个常见的中文姓。
            'cname': Random.cname(),//随机生成一个常见的中文姓名。

            //web
            'url': Random.url('http','baidu.com'), // 随机生成一个 URL。
            'protocol': Random.protocol(), //随机生成一个 URL 协议
            'domain': Random.domain(), //随机生成一个域名。
            'tld': Random.tld(), //随机生成一个顶级域名
            'email':Random.email('qq.com'),//随机生成一个邮箱
            'ip':Random.ip(),//随机生成一个 IP 地址。

            //address
            'region':Random.region(),//随机生成一个（中国）大区。
            'province':Random.province(),//随机生成一个（中国）省（或直辖市、自治区、特别行政区）
            'city':Random.city(true),//布尔值。指示是否生成所属的省。
            'county':Random.county(true),//随机生成一个（中国）县。
            'zip':Random.zip(),//随机生成一个邮政编码（六位数字）
            'address': Random.province(), // 生成地址

            //helper
            'capitalize': Random.capitalize('hello'),//把字符串的第一个字母转换为大写。
            'upper': Random.upper( 'hello' ),//把字符串转换为大写。
            'lower': Random.lower( 'HELLO' ),//把字符串转换为小写。
            'pick': Random.pick( ['a', 'e', 'i', 'o', 'u'] ),//从数组中随机选取一个元素，并返回。
            'shuffle': Random.shuffle( ['a', 'e', 'i', 'o', 'u'] ), //打乱数组中元素的顺序，并返回。

            //miscellaneous
            'guid': Random.guid(), //随机生成一个 GUID。
            'id': Random.id(), //随机生成一个 18 位身份证。
            'increment': Random.increment(2), //生成一个全局的自增整数。自增为2
```
