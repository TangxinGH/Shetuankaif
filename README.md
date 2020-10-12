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
Note that URLSearchParams is not supported by all browsers (see caniuse.com), but there is a polyfill available (make sure to polyfill the global environment).

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
