package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.mydao.LoginMapper;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import com.example.demo.token.AuthManager;
import com.example.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private AuthManager authManager;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map login(String phone, String password) {
        Map<String,String> loginMap = new HashMap<>(2);
        loginMap.put("phone",phone);
        loginMap.put("password",password);
        Map loginInfo = loginMapper.login(loginMap);
        return this.setData(loginInfo);
    }

    @Override
    public Map loginByOpenId(String openId) {
        Map loginInfo = loginMapper.loginByOpenId(openId);
        return this.setData(loginInfo);
    }

    private Map setData(Map loginInfo){
        if(loginInfo != null){
            //获取token
            String token = authManager.login(loginInfo);
            loginInfo.put("token",token);
            //更新登录时间
            User user = new User();
            user.setUpdateUserId(Integer.valueOf(loginInfo.get("id")+""));
            user.setLastLoginTime(DateUtil.getDateTime());
            userMapper.updateByPrimaryKeySelective(user);
            return loginInfo;
        }
        return null;
    }
}
