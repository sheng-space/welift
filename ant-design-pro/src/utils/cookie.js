import Cookies from 'js-cookie';

// 保存的key
const STORAGE_TOKEN_NAME = 'TOKEN_VALUE'; // token
const STORAGE_TOKEN_ID = 'TOKEN_ID_VALUE'; // token_id
const STORAGE_TOKEN_GROUP = 'TOKEN_GROUP_VALUE'; // token_group

// 获取
export function getDto(key) {
  const token = Cookies.get(STORAGE_TOKEN_NAME);
  const tokenId = Cookies.get(STORAGE_TOKEN_ID);
  const tokenGroup = Cookies.get(STORAGE_TOKEN_GROUP);
  if(key === 'token') {
    return token;
  }else if(key === 'id') {
    return tokenId;
  }else if(key === 'group') {
    return tokenGroup;
  }else if(key === 'obj') {
    // 获得一个obj
    return tokenObj(token, tokenId, tokenGroup);
  }else {
    return Cookies.get(key);
  }
}
function tokenObj(token, tokenId, tokenGroup) {
  return {
    token,
    tokenId,
    tokenGroup,
  }
}

// 保存
export function saveDto(key, val, time) {
  if(key === 'token') {
    Cookies.set(STORAGE_TOKEN_NAME, val, { expires: timeOption(time) });
    return
  }else if(key === 'token_id') {
    Cookies.set(STORAGE_TOKEN_ID, val, { expires: timeOption(time) });
  }else if(key === 'token_group') {
    Cookies.set(STORAGE_TOKEN_GROUP, val, { expires: timeOption(time) });
  }else {
    Cookies.set(key, val, { expires: timeOption(time) });
  }
}

// 删除token
export function removeToken() {
  Cookies.remove(STORAGE_TOKEN_NAME);
  Cookies.remove(STORAGE_TOKEN_ID);
  Cookies.remove(STORAGE_TOKEN_GROUP);
}

// 把 秒 转成 天
function timeOption(time) {
  return parseInt(time) / (24*60*60);
}
