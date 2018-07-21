package com.happok.xiyan.mediaservice.common;

public enum ClientStatusEnum {

    ONLINE("online"),
    OFFLINE("offline");

    ClientStatusEnum(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
