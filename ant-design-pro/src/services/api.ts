import {requestPost} from '@/utils/request';
export async function query(param:{url:String}){
  return requestPost(param.url,param);
}
