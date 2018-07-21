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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClientControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

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
    public void updateClient() throws Exception {

        JSONObject res_upload = new JSONObject(true);
        res_upload.put("uuid", "4a849a95-f718-4b66-aec5-197b2e18f9ba");
        res_upload.put("push_number", "15");
        res_upload.put("live_number", "10");
        res_upload.put("status", "online");

        String responseString = mvc.perform(post("/mediaservice/clients")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(res_upload.toJSONString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.printf("StreamClientController:" + responseString);
    }

    @Test
    public void getClient() throws Exception {
        String responseString = mvc.perform(get("/mediaservice/clients/4a849a95-f718-4b66-aec5-197b2e18f9ba")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result.uuid").value("4a849a95-f718-4b66-aec5-197b2e18f9ba"))
                .andExpect(jsonPath("$.result.push_number").value(15))
                .andExpect(jsonPath("$.result.live_number").value(10))
                .andExpect(jsonPath("$.result.status").value("online"))
                .andReturn().getResponse().getContentAsString();

        System.out.printf("regeditStreamClient:" + responseString);
    }

    @Test
    public void getClients() throws Exception {
        String responseString = mvc.perform(get("/mediaservice/clients")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result").isArray())
                .andExpect(jsonPath("$.result[0].uuid").value("4a849a95-f718-4b66-aec5-197b2e18f9ba"))
                .andExpect(jsonPath("$.result[0].push_number").value(15))
                .andExpect(jsonPath("$.result[0].live_number").value(10))
                .andExpect(jsonPath("$.result[0].status").value("online"))
                .andReturn().getResponse().getContentAsString();

        System.out.printf("regeditStreamClient:" + responseString);
    }
}