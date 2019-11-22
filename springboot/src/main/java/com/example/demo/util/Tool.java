package com.example.demo.util;

import java.util.UUID;

public class Tool {
    /**
     * @功能：获取uuid
     * @return
     */
    public static String getUUID(){
        UUID uuid= UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
