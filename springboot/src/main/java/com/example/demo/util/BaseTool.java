package com.example.demo.util;

import net.sf.json.JSONObject;

public class BaseTool {

    public static String outSuccess(Object result, String resultMsg) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode("0");
        resultDTO.setMsg(resultMsg);
        resultDTO.setData(result);
        return JSONObject.fromObject(resultDTO).toString();
    }
    public static String outSuccess(Object result) {
        return outSuccess(result,"");
    }
    public static String outSuccess() {
        return outSuccess("{}");
    }
    public static String outError(String resultMsg, Object result) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode("1");
        resultDTO.setMsg(resultMsg);
        resultDTO.setData(result);
        return JSONObject.fromObject(resultDTO).toString();
    }

    public static String outError(String resultMsg) {
        return outError(resultMsg,"{}");
    }
    public static String outError() {
        return outError("","{}");
    }

}
