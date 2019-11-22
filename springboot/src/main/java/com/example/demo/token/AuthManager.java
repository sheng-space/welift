package com.example.demo.token;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户token
 * @author sheng
 * @date 2019/11/22
 */
@Component
public class AuthManager {

    private String tokenStr = "token";

    @Autowired
    private TokenManager tokenManager;

    /**
     * 获取请求体
     * @return
     */
    public HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 登录
     * @param userInfo
     * @return
     */
    public String login(Map userInfo){
        return tokenManager.getToken(JSON.toJSONString(userInfo));
    }

    /**
     * 获取该访问用户信息
     * @return
     */
    public Map getUserInfo(){
        HttpServletRequest request=getRequest();
        String token = request.getAttribute(tokenStr).toString();
        String userInfo=tokenManager.getUserInfoByToken(token);
        if(userInfo != null){
            return JSONObject.parseObject(userInfo, Map.class);
        }else{
           return null;
        }

    }

    /**
     * 刷新该登录用户，延时
     */
    public void refreshUserInfo(){
        HttpServletRequest request=getRequest();
        String token=request.getAttribute(tokenStr).toString();
        tokenManager.refreshToken(token);
    }

    /**
     * 注销该访问用户
     */
    public void loginOff(){
        HttpServletRequest request=getRequest();
        String token=request.getAttribute(tokenStr).toString();
        tokenManager.loginOut(token);
    }
}
