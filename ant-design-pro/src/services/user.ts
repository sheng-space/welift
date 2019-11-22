import {requestPost} from '@/utils/request';

export async function query(param:{}): Promise<any> {
  return requestPost('/api/users',param);
}

export async function queryCurrent(param:{}): Promise<any> {
  return requestPost('/api/currentUser',param);
}

export async function queryNotices(param:{}): Promise<any> {
  return requestPost('/api/notices',param);
}
