package com.example.demo.util;

public enum ResultEnum {
    //**********  异常  ************
    CODE_800000("800000", "系统异常！"),
    CODE_800002("800002", "参数处理异常！"),
    CODE_800003("800003", "业务系统调用异常！"),

    //**********  失败  ************
    CODE_800001("800010", "参数校验失败！"),
    CODE_800010("800011", "业务系统调用失败！"),

    //**********  成功  ************
    CODE_0("0", "请求成功！");

    private String resultCode;//结果编码
    private String resultMsg;//结果信息

    ResultEnum(String code, String msg) {
        this.resultCode = code;
        this.resultMsg = msg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}
