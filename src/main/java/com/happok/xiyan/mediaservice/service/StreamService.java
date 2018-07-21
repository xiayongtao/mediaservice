package com.happok.xiyan.mediaservice.service;

import com.happok.xiyan.mediaservice.entity.StreamEntity;
import com.happok.xiyan.mediaservice.mapper.StreamMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StreamService {

    @Resource
    private StreamMapper streamMapper = null;



    public boolean updateStream(StreamEntity streamEntity) {
        return streamMapper.updateStream(streamEntity);
    }

    public List<StreamEntity> getStreams(String uuid) {
        return streamMapper.getStreams(uuid);
    }

    public StreamEntity getStream(String uuid, String name) {
        return streamMapper.getStream(uuid, name);
    }

}
