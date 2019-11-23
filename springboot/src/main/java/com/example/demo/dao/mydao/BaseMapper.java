package com.example.demo.dao.mydao;


import java.util.Map;

public interface LoginMapper {

    Map login(String phone,String password);

    Map loginByOpenId(String openId);
}