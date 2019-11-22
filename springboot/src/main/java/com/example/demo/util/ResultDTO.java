package com.example.demo.util;

public class ResultDTO<T> {

    private String code;//结果编码

    private String msg;//结果信息

    private T data;//结果内容

    public String getCode() {
        return code;
    }

    public void setCode(String resultCode) {
        this.code = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String resultMsg) {
        this.msg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T result) {
        this.data = result;
    }
}

