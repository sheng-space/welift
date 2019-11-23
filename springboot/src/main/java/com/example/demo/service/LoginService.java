package com.example.demo.service;


import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 登录服务
 * @author sheng
 * @date 2019/11/21
 */
@Service
public interface LoginService {

    Map login(String phone,String password);

    Map loginByOpenId(String openId);
}
