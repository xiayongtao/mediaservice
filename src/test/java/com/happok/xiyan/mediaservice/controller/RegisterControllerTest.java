package com.happok.xiyan.mediaservice.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import javax.annotation.Resource;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegisterControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

    //模拟mvc对象类.
    private MockMvc mvc;

    @Resource
    private WebApplicationContext webApplicationContext = null;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void regeditStreamClient() throws Exception {

        JSONObject res_upload = new JSONObject(true);
        res_upload.put("uuid", UUID.randomUUID().toString());
        res_upload.put("server_ip", "127.0.0.1");
        res_upload.put("type", "pull");
        res_upload.put("http_port", "80");
        res_upload.put("rtmp_port", "1935");

        String responseString = mvc.perform(post("/mediaservice/registers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(res_upload.toJSONString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.printf("regeditStreamClient:" + responseString);
    }

    @Test
    public void getStreamClients() throws Exception {

        String responseString = mvc.perform(get("/mediaservice/registers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result").isArray())
                .andExpect(jsonPath("$.result[0].uuid").value("9926100a-211f-445d-b752-733c0af131f8"))
                .andExpect(jsonPath("$.result[0].server_ip").value("127.0.0.1"))
                .andExpect(jsonPath("$.result[0].http_port").value(80))
                .andReturn().getResponse().getContentAsString();

        System.out.printf("regeditStreamClient:" + responseString);
    }

    @Test
    public void updateStreamClient() throws Exception {

        JSONObject res_upload = new JSONObject(true);
        res_upload.put("server_ip", "192.168.1.100");
        res_upload.put("type", "pull");
        res_upload.put("http_port", "80");
        res_upload.put("rtmp_port", "1935");

        String responseString = mvc.perform(put("/mediaservice/registers/9926100a-211f-445d-b752-733c0af131f8")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(res_upload.toJSONString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.printf("regeditStreamClient:" + responseString);
    }

    @Test
    public void deleteStreamClient() throws Exception {

        String responseString = mvc.perform(delete("/mediaservice/registers/9926100a-211f-445d-b752-733c0af131f8")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        System.out.printf("regeditStreamClient:" + responseString);
    }

}