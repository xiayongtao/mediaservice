package com.happok.xiyan.mediaservice.common;

import com.alibaba.fastjson.JSONObject;


public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(200, "成功"),

    STREAM_NOT_FOUND(404, "不存在"),
    STREAM_INSERT_FAILED(500,"内部错误"),
    STREAM_BAD_REQUEST(400, "错误的请求");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public String toJSONString() {

        JSONObject res = new JSONObject(true);
        res.put("code", this.code);
        res.put("message", this.message);
        return JSONObject.toJSONString(this);
    }

}
