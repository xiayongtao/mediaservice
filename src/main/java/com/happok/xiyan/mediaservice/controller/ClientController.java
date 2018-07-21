package com.happok.xiyan.mediaservice.controller;

import com.happok.xiyan.mediaservice.common.Result;
import com.happok.xiyan.mediaservice.common.ResultCode;
import com.happok.xiyan.mediaservice.entity.ClientEntity;
import com.happok.xiyan.mediaservice.service.ClientService;
import com.happok.xiyan.mediaservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/mediaservice/")

public class ClientController {

    @Autowired
    private ClientService clientService = null;

    @Autowired
    private RegisterService registerService = null;


    @PostMapping("/clients")
    public Object updateClient(HttpServletResponse response,
                               @RequestBody(required = false) @Valid ClientEntity clientEntity,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Result.failure(ResultCode.STREAM_BAD_REQUEST);
        }

        if (!registerService.IsClientExist(clientEntity.getUuid())) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Result.failure(ResultCode.STREAM_NOT_FOUND);
        }

        if (!clientService.updateClient(clientEntity)) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return Result.failure(ResultCode.STREAM_INSERT_FAILED);
        }

        return Result.success();
    }

    @GetMapping("/clients/{uuid}")
    public Object getClient(@PathVariable("uuid") String uuid) {
        return Result.success(clientService.getClient(uuid));
    }

    @GetMapping("/clients")
    public Object getClients() {
        return Result.success(clientService.getClients());
    }
}
