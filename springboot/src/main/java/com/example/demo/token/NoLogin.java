package com.example.demo.token;


import java.lang.annotation.*;

/**
 * 注解：不拦截token
 * @author sheng
 * @date 2019/11/22
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoLogin {

}
