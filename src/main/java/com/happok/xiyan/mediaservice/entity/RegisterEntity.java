package com.happok.xiyan.mediaservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RegisterEntity {

    @NotBlank(message = "uuid不能为空")
    @Length(min = 36, max = 36, message = "uuid格式错误")
    private String uuid;

    @NotBlank(message = "服务器IP不能为空")
    @Length(max = 16)
    @Pattern(regexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", message = "IP格式不正确")
    private String server_ip;

    @NotBlank
    private String type;

    @Range(min = 0, max = 63353, message = "端口错误")
    private Integer http_port;
    @Range(min = 0, max = 63353, message = "端口错误")
    private Integer rtmp_port;
    @Range(min = 0, max = 63353, message = "端口错误")
    private Integer rtsp_port;
    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getServer_ip() {
        return server_ip;
    }

    public void setServer_ip(String server_ip) {
        this.server_ip = server_ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHttp_port() {
        return http_port;
    }

    public void setHttp_port(Integer http_port) {
        this.http_port = http_port;
    }

    public Integer getRtmp_port() {
        return rtmp_port;
    }

    public void setRtmp_port(Integer rtmp_port) {
        this.rtmp_port = rtmp_port;
    }

    public Integer getRtsp_port() {
        return rtsp_port;
    }

    public void setRtsp_port(Integer rtsp_port) {
        this.rtsp_port = rtsp_port;
    }
}
