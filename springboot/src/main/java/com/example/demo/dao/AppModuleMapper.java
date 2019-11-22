package com.example.demo.dao;

import com.example.demo.entity.AppModule;

public interface AppModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppModule record);

    int insertSelective(AppModule record);

    AppModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppModule record);

    int updateByPrimaryKey(AppModule record);
}