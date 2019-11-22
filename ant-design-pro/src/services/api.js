import { stringify } from 'qs';
import {requestPost} from '@/utils/request';

export async function queryProjectNotice() {
  return requestPost('/api/project/notice');
}

export async function queryActivities() {
  return requestPost('/api/activities');
}

export async function queryRule(params) {
  return requestPost(`/api/rule?${stringify(params)}`);
}

export async function removeRule(params) {
  return requestPost('/api/rule', {
    method: 'POST',
    data: {
      ...params,
      method: 'delete',
    },
  });
}

export async function addRule(params) {
  return requestPost('/api/rule', {
    method: 'POST',
    data: {
      ...params,
      method: 'post',
    },
  });
}

export async function updateRule(params = {}) {
  return requestPost(`/api/rule?${stringify(params.query)}`, {
    method: 'POST',
    data: {
      ...params.body,
      method: 'update',
    },
  });
}

export async function fakeSubmitForm(params) {
  return requestPost('/api/forms', {
    method: 'POST',
    data: params,
  });
}

export async function fakeChartData() {
  return requestPost('/api/fake_chart_data');
}

export async function queryTags() {
  return requestPost('/api/tags');
}

export async function queryBasicProfile(id) {
  return requestPost(`/api/profile/basic?id=${id}`);
}

export async function queryAdvancedProfile() {
  return requestPost('/api/profile/advanced');
}

export async function queryFakeList(params) {
  return requestPost(`/api/fake_list?${stringify(params)}`);
}

export async function removeFakeList(params) {
  const { count = 5, ...restParams } = params;
  return requestPost(`/api/fake_list?count=${count}`, {
    method: 'POST',
    data: {
      ...restParams,
      method: 'delete',
    },
  });
}

export async function addFakeList(params) {
  const { count = 5, ...restParams } = params;
  return requestPost(`/api/fake_list?count=${count}`, {
    method: 'POST',
    data: {
      ...restParams,
      method: 'post',
    },
  });
}

export async function updateFakeList(params) {
  const { count = 5, ...restParams } = params;
  return requestPost(`/api/fake_list?count=${count}`, {
    method: 'POST',
    data: {
      ...restParams,
      method: 'update',
    },
  });
}

export async function fakeAccountLogin(params) {
  return requestPost('/api/login/account', {
    method: 'POST',
    data: params,
  });
}

export async function fakeRegister(params) {
  return requestPost('/api/register', {
    method: 'POST',
    data: params,
  });
}

export async function queryNotices(params = {}) {
  return requestPost(`/api/notices?${stringify(params)}`);
}

export async function getFakeCaptcha(mobile) {
  return requestPost(`/api/captcha?mobile=${mobile}`);
}
