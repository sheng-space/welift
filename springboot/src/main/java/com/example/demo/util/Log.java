package com.example.demo.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志
 */
public class Log {

    private final static Logger logger = LoggerFactory.getLogger(Log.class);
    /**
     * 打印
     */
    public static void error(String str){
        logger.error(str);
    }
    public static void info(String str){
         logger.info(str);
    }
    public static void debug(String str){
        logger.debug(str);
    }
}
