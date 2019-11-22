package com.example.demo.dao;

import com.example.demo.entity.Seckill;

public interface SeckillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seckill record);

    int insertSelective(Seckill record);

    Seckill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seckill record);

    int updateByPrimaryKey(Seckill record);
}