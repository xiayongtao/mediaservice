package com.happok.xiyan.mediaservice.common;

public enum ServerTypeEnum {

    //pull/push/live/notranscode/transcode/rtsp
    PULL(0, "pull"),
    PUSH(1, "push"),
    NOTRANSCODE(2, "notranscode"),
    TRANSCODE(3, "transcode"),
    RTSP(4, "rtps");

    private Integer code;
    private String message;

    ServerTypeEnum(Integer code, String message) {
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
        for (ServerTypeEnum item : ServerTypeEnum.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ServerTypeEnum item : ServerTypeEnum.values()) {
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

}
