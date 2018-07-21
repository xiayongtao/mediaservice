package com.happok.xiyan.mediaservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ClientEntity {

    private Integer id;
    private Integer push_number;
    private Integer live_number;

    @NotBlank
    @Length(max = 36)
    private String uuid;

    @NotBlank
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPush_number() {
        return push_number;
    }

    public void setPush_number(Integer push_number) {
        this.push_number = push_number;
    }

    public Integer getLive_number() {
        return live_number;
    }

    public void setLive_number(Integer live_number) {
        this.live_number = live_number;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
