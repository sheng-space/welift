package com.example.demo.token;

import java.util.Map;

/**
 * 登录的token
 * @author sheng
 * @date 2019/11/22
 */
public interface TokenManager {

    /**
     * 创建token
     * @param userInfo
     * @return
     */
    String getToken(String userInfo);

    /**
     * 刷新用户
     * @param token
     */
    void refreshToken(String token);

    /**
     * 用户退出登陆
     * @param token
     */
    void loginOut(String token);

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    String getUserInfoByToken(String token);
}
