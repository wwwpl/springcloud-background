package com.jdjr.euraka.server.cosume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangfei
 * @date 2018/9/19 11:33
 */
@RestController
@Configuration
public class TestController {

    private static final String REST_URL = "http://eureka-server-provide";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("test")
    public String test(){
        return restTemplate.getForEntity(REST_URL+"/test/",String.class).getBody();
    }
}

