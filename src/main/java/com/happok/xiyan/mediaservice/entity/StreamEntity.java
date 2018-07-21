package com.happok.xiyan.mediaservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class StreamEntity {

    private Integer id;

    @NotBlank
    @Length(max = 36)
    private String uuid;

    @NotBlank
    @Length(max = 50)
    private String name;
    private Integer clients;
    private double send_bytes;
    private double recv_bytes;
    private boolean publish_active;
    private String recv_30s;
    private String send_30s;
    private String vcodec;
    private String acodec;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public double getSend_bytes() {
        return send_bytes;
    }

    public void setSend_bytes(double send_bytes) {
        this.send_bytes = send_bytes;
    }

    public double getRecv_bytes() {
        return recv_bytes;
    }

    public void setRecv_bytes(double recv_bytes) {
        this.recv_bytes = recv_bytes;
    }

    public boolean isPublish_active() {
        return publish_active;
    }

    public void setPublish_active(boolean publish_active) {
        this.publish_active = publish_active;
    }

    public String getRecv_30s() {
        return recv_30s;
    }

    public void setRecv_30s(String recv_30s) {
        this.recv_30s = recv_30s;
    }

    public String getSend_30s() {
        return send_30s;
    }

    public void setSend_30s(String send_30s) {
        this.send_30s = send_30s;
    }

    public String getVcodec() {
        return vcodec;
    }

    public void setVcodec(String vcodec) {
        this.vcodec = vcodec;
    }

    public String getAcodec() {
        return acodec;
    }

    public void setAcodec(String acodec) {
        this.acodec = acodec;
    }
}
