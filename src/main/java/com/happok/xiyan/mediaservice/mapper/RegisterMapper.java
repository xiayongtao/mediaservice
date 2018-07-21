package com.happok.xiyan.mediaservice.mapper;

import com.happok.xiyan.mediaservice.entity.RegisterEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisterMapper {

    public boolean insertClient(RegisterEntity registerEntity);

    public List<RegisterEntity> getStreamClients();

    public RegisterEntity getStreamClientByUUID(@Param("uuid") String uuid);

    public boolean deleteStreamClientByUUID(@Param("uuid") String uuid);

    public Integer IsExist(@Param("uuid") String uuid);
}
