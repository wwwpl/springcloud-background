package com.jdjr.euraka.server.cosume1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfei
 * @date 2018/9/19 11:33
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return "111111111111111111111";
    }
}

