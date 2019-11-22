package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis string操作工具类
 */
@Component
public class RedisStringUtils {
    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key, String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    public void setKey(String key, String value, long expire){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value,expire, TimeUnit.SECONDS);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }
}
