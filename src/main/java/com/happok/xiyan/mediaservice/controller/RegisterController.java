package com.happok.xiyan.mediaservice.controller;

import com.alibaba.druid.util.StringUtils;
import com.happok.xiyan.mediaservice.common.Result;
import com.happok.xiyan.mediaservice.common.ResultCode;
import com.happok.xiyan.mediaservice.entity.RegisterEntity;
import com.happok.xiyan.mediaservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/mediaservice/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService = null;

    @PostMapping("/clients")
    public Object RegeditStreamClient(HttpServletResponse response,
                                      @RequestBody(required = true) @Valid RegisterEntity registerEntity,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Result.failure(ResultCode.STREAM_BAD_REQUEST);
        }

        if (!registerService.registerStreamClinet(registerEntity)) {
            return Result.failure(ResultCode.STREAM_INSERT_FAILED);
        }

        return Result.success();
    }

    @GetMapping("/clients")
    public Object getStreamClients() {
        return Result.success(registerService.getStreamClients());
    }

    @GetMapping("/clients/{uuid}")
    public Object getStreamClient(@PathVariable("uuid") String uuid) {
        return Result.success(registerService.getStreamClient(uuid));
    }

    @PutMapping("/clients/{uuid}")
    public Object updateStreamClient(HttpServletResponse response,
                                     @PathVariable("uuid") String uuid,
                                     @RequestBody(required = true) RegisterEntity registerEntity,
                                     BindingResult bindingResult) {

        if (StringUtils.isEmpty(uuid)) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Result.failure(ResultCode.STREAM_BAD_REQUEST);
        }

        registerEntity.setUuid(uuid);
        if (!registerService.registerStreamClinet(registerEntity)) {
            return Result.failure(ResultCode.STREAM_INSERT_FAILED);
        }

        return Result.success();
    }

    @DeleteMapping("/clients/{uuid}")
    public Object deleteStreamClient(@PathVariable("uuid") String uuid) {

        if (!registerService.deleteStreamClientByUUID(uuid)) {
            return Result.failure(ResultCode.STREAM_INSERT_FAILED);
        }

        return Result.success();
    }
}
