package com.example.demo.dao.mydao;


import java.util.Map;

/**
 * 基础mapper
 * @author sheng
 * @date 2019/11/23
 */
public interface BaseMapper {

    /**
     * 用户列表
     * @param map
     * @return
     */
    Map userList(Map map);

    /**
     * 组织列表
     * @param map
     * @return
     */
    Map orgList(Map map);
}