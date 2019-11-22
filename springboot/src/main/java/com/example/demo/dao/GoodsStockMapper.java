package com.example.demo.dao;

import com.example.demo.entity.GoodsStock;

public interface GoodsStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsStock record);

    int insertSelective(GoodsStock record);

    GoodsStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsStock record);

    int updateByPrimaryKey(GoodsStock record);
}