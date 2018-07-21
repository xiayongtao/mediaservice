package com.happok.xiyan.mediaservice.service;

import com.happok.xiyan.mediaservice.entity.ClientEntity;
import com.happok.xiyan.mediaservice.mapper.ClientMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientService {

    @Resource
    private ClientMapper clientMapper = null;

    public boolean updateClient(ClientEntity clientEntity) {
        return clientMapper.updateClient(clientEntity);
    }

    public List<ClientEntity> getClients() {
        return clientMapper.getClients();
    }

    public ClientEntity getClient(String uuid) {
        return clientMapper.getClientByUUID(uuid);
    }

    public boolean IsClientExist(String uuid) {

        if (clientMapper.IsExist(uuid) > 0) {
            return true;
        }

        return false;
    }
}
