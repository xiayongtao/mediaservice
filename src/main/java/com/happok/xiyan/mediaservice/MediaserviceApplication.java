package com.happok.xiyan.mediaservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@MapperScan(value = "com.happok.xiyan.mediaservice.mapper")
@EnableFeignClients
@EnableDiscoveryClient
public class MediaserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaserviceApplication.class, args);
    }
}
