package com.example.demo.service.impl;

import com.example.demo.dao.SeckillMapper;
import com.example.demo.entity.Seckill;
import com.example.demo.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author sheng
 * @date 2019/11/21
 */
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillMapper seckillMapper;

    @Override
    public int insert(Seckill seckill) {
        return seckillMapper.insert(seckill);
    }

    @Override
    public List<Seckill> getAll() {
        return null;
    }
}
