package com.example.demo.service;

import com.example.demo.entity.Seckill;
import java.util.List;

/**
 * @author sheng
 * @date 2019/11/21
 */
public interface SeckillService {

    int insert(Seckill seckill);

    List<Seckill> getAll();
}
