package com.example.demo.dao;

import com.example.demo.entity.FloorDetail;

public interface FloorDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FloorDetail record);

    int insertSelective(FloorDetail record);

    FloorDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FloorDetail record);

    int updateByPrimaryKey(FloorDetail record);
}