package com.happok.xiyan.mediaservice.mapper;

import com.happok.xiyan.mediaservice.entity.ClientEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientMapper {

    public boolean updateClient(ClientEntity clientEntity);

    public List<ClientEntity> getClients();

    public ClientEntity getClientByUUID(@Param("uuid") String uuid);

    public Integer IsExist(@Param("uuid") String uuid);
}
