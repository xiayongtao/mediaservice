package com.happok.xiyan.mediaservice.controller;


import com.happok.xiyan.mediaservice.common.Result;
import com.happok.xiyan.mediaservice.common.ResultCode;
import com.happok.xiyan.mediaservice.entity.StreamEntity;
import com.happok.xiyan.mediaservice.service.ClientService;
import com.happok.xiyan.mediaservice.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/mediaservice/client")
public class StreamController {

    @Resource
    private StreamService streamService = null;

    @Autowired
    private ClientService clientService = null;

    @PostMapping("/{uuid}/streams")
    public Object updateStream(HttpServletResponse response,
                               @PathVariable("uuid") String uuid,
                               @RequestBody @Valid StreamEntity streamEntity,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Result.failure(ResultCode.STREAM_BAD_REQUEST);
        }

        if (!clientService.IsClientExist(uuid)) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Result.failure(ResultCode.STREAM_NOT_FOUND);
        }

        if (!streamService.updateStream(streamEntity)) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return Result.failure(ResultCode.STREAM_INSERT_FAILED);
        }

        return Result.success();
    }

    @PutMapping("/{uuid}/streams/{name}")
    public Object modifyStream(HttpServletResponse response, @PathVariable("uuid") String uuid, @PathVariable("name") String name,
                               @RequestBody(required = false) StreamEntity streamEntity) {

        if (null == streamEntity) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Result.failure(ResultCode.STREAM_BAD_REQUEST);
        }

        if (!clientService.IsClientExist(uuid)) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Result.failure(ResultCode.STREAM_NOT_FOUND);
        }

        streamEntity.setUuid(uuid);
        streamEntity.setName(name);

        if (!streamService.updateStream(streamEntity)) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Result.failure(ResultCode.STREAM_BAD_REQUEST);
        }

        return Result.success();
    }

    @GetMapping("/{uuid}/streams")
    public Object getStreams(@PathVariable("uuid") String uuid) {
        return Result.success(streamService.getStreams(uuid));
    }

    @GetMapping("/{uuid}/streams/{name}")
    public Object getStream(@PathVariable("uuid") String uuid, @PathVariable("name") String name) {
        return Result.success(streamService.getStream(uuid, name));
    }
}


