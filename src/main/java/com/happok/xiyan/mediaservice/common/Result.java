package com.happok.xiyan.mediaservice.common;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Result implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;
    private String message;
    private Object result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String messge) {
        this.message = messge;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.result = data;
    }

    public static JSONObject toJsonObject(Result obj) {
        JSONObject res = new JSONObject(true);

        res.put("code", obj.code);
        res.put("message", obj.message);
        if (null != obj.result) {
            res.put("result", obj.result);
        }

        return res;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {

        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setResult(data);

        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setResult(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.message = code.message();
    }
}
