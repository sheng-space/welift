package com.example.demo.dao;

import com.example.demo.entity.Floor;

public interface FloorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Floor record);

    int insertSelective(Floor record);

    Floor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Floor record);

    int updateByPrimaryKey(Floor record);
}