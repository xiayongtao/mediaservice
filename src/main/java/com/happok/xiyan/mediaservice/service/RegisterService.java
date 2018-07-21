package com.happok.xiyan.mediaservice.service;

import com.happok.xiyan.mediaservice.entity.RegisterEntity;
import com.happok.xiyan.mediaservice.mapper.RegisterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegisterService {

    @Resource
    private RegisterMapper registerMapper = null;

    public boolean registerStreamClinet(RegisterEntity registerEntity) {
        return registerMapper.insertClient(registerEntity);
    }

    public List<RegisterEntity> getStreamClients() {
        return registerMapper.getStreamClients();
    }

    public RegisterEntity getStreamClient(String uuid) {
        return registerMapper.getStreamClientByUUID(uuid);
    }

    public boolean deleteStreamClientByUUID(String uuid) {
        return registerMapper.deleteStreamClientByUUID(uuid);
    }

    public boolean IsClientExist(String uuid) {
        if (registerMapper.IsExist(uuid) > 0) {
            return true;
        }

        return false;
    }
}
