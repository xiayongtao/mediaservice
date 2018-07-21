package com.happok.xiyan.mediaservice.mapper;

import com.happok.xiyan.mediaservice.entity.StreamEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StreamMapper {

    public boolean updateStream(StreamEntity streamEntity);

    public List<StreamEntity> getStreams(@Param("uuid") String uuid);

    public StreamEntity getStream(@Param("uuid") String uuid, @Param("name") String name);
}
