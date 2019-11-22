package com.example.demo.token;

import com.example.demo.redis.RedisStringUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * @author sheng
 * @date 2019/11/22
 */
@Component
public class RedisTokenManager implements TokenManager {

    @Resource
    private RedisStringUtils redis;

    private long expires = 7200;
    /**
     * 创建token
     * @param userInfo
     * @return
     */
    @Override
    public String getToken(String userInfo){
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        redis.setKey(token, userInfo,expires);
        return token;
    }

    /**
     * 刷新用户
     * @param token
     */
    @Override
    public void refreshToken(String token){
        String userInfo = redis.getValue(token);
        redis.setKey(token, userInfo,expires);
    }

    /**
     * 用户退出登陆
     * @param token
     */
    @Override
    public void loginOut(String token){
        redis.setKey(token,"",10);
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @Override
    public String getUserInfoByToken(String token){
        redis.getValue(token);
        return null;
    }
}
