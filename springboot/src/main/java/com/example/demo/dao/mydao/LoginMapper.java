package com.example.demo.dao.mydao;


import java.util.Map;

/**
 * 登录mapper
 * @author sheng
 * @date 2019/11/23
 */
public interface LoginMapper {

    /**
     * 用户账号密码登录
     * @param map
     * @return
     */
    Map login(Map map);

    /**
     * 用户openId登录
     * @param openId
     * @return
     */
    Map loginByOpenId(String openId);
}