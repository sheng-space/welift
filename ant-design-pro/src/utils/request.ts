import axios from 'axios';
const { stringify } = require('qs');
import router from 'umi/router';
import { message } from 'antd';

// 全局设定请求类型
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.timeout = 10000; // 超时设置,超时进入错误回调，进行相关操作
axios.defaults.withCredentials = true; // 是否支持跨域cookie
//请求拦截
axios.interceptors.request.use(
  config => {
    const token = localStorage.getItem("token")||"";
    const url = config.url||"";
    if (token||url.indexOf('/login') > 0) {
      config.headers['token'] = token;
    }else{
      router.push('/login');
    }
    return config;
  }, function (error) {
     //没有token跳到登录页
     message.error("加载超时！");
    return Promise.reject(error);
  }
)

// 响应拦截
axios.interceptors.response.use((res) => {
  if (res.status === 401) {
    message.warning("token不存在！");
  }
  return res;
}, function(error) {
  if (error) {
    // 请求配置发生的错误
    if (!error.response) {
      return console.log('Error', error.message);
    }
    // 获取状态码
    const code = error.response.status;
    const errortext = codeMessage[code] || error.response.statusText;
    message.error(errortext)
    // 错误状态处理跳转对应的页面
    setTimeout(function(){
      let path = '/exception/403';
      if (code === 401) {
        path = '/login';
      } else if (code === 403) {
        path = '/exception/403';
      } else if (code >= 404 && code < 422) {
        path = '/exception/404';
      } else if (code === 500) {
        path = '/exception/500';
      }
      router.push(path);
    },1000);
  }
  return null;
})

/**
 * post 请求封装
 */
export function requestPost (url:any, params:{}) {
  return axios.post(url,stringify(params)).then(response => {
    return response.data;
  }).catch(error => {
    return {code:"1",msg:"请求失败！"};
  })
}

/**
 * get 请求封装
 */
export function requestGet(url:any, params = {}) {

  return axios.get(url, {
    params: params,
    validateStatus: function (status) {return status >= 200 && status < 300}//200~300为正常，其他的当异常处理
  }).then(response => {

    // 返回后端返回数据
    return response.data
  }).catch(error => {
    // 异常处理

  })
}

/**
 * 单页面的多接口的并发请求（await 导致的多余等待）
 */
export function requestAll (requests = []) {

  // 使用 axios 的 all 方法
  return axios.all(requests).then(resultArr => {
    // 对结果做特殊化处理，此处是对返回接口 code 在一定范围内作信息弹框
    for (let result of resultArr) {

    }
    //  返回每个方法返回的接口数据
    return resultArr
  }).catch(error => {
    // 异常处理

  })
}

// 状态码错误信息
const codeMessage = {
  200: '服务器成功返回请求的数据。',
  201: '新建或修改数据成功。',
  202: '一个请求已经进入后台排队（异步任务）。',
  204: '删除数据成功。',
  400: '发出的请求有错误，服务器没有进行新建或修改数据的操作。',
  401: '用户没有权限（令牌、用户名、密码错误）。',
  403: '用户得到授权，但是访问是被禁止的。',
  404: '发出的请求针对的是不存在的记录，服务器没有进行操作。',
  406: '请求的格式不可得。',
  410: '请求的资源被永久删除，且不会再得到的。',
  422: '当创建一个对象时，发生一个验证错误。',
  500: '服务器发生错误，请检查服务器。',
  502: '网关错误。',
  503: '服务不可用，服务器暂时过载或维护。',
  504: '网关超时。',
};
