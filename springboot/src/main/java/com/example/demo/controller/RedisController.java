package com.example.demo.controller;
import com.example.demo.redis.RedisStringUtils;
import com.example.demo.token.NoLogin;
import com.example.demo.util.BaseTool;
import net.sf.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * redis
 * @author sheng
 * @date 2019/11/21
 */
@RestController
@RequestMapping("/redis")
public class RedisController extends BaseTool {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RedisStringUtils redis;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public String add(@RequestParam String json) {
        try{
            JSONObject jt = JSONObject.fromObject(json);
            redis.setKey(jt.getString("key").toString(), jt.getString("value").toString(),jt.getLong("expire"));
        }catch (NumberFormatException e){
            e.printStackTrace();
            return outError("参数异常");
        }
        return outSuccess();
    }
    @RequestMapping(value = "/get")
    @ResponseBody
    public String get(@RequestParam("key") String key){
        String user = redis.getValue(key);
        if(user != null){
            return outSuccess(user);
        }else{
            return outError("key:"+key+"不存在value");
        }
    }

    @RequestMapping(value = "/text")
    @ResponseBody
    public String text() {
        String content = "lalalal";
        //this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", content);
        return outSuccess(content);
    }

    @RequestMapping(value = "/text2")
    @ResponseBody
    @NoLogin
    public String text2() {
        String content = "lalalal";
        //this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", content);
        return outSuccess(content);
    }
}
