package com.jdjr.euraka.server.provide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfei
 * @date 2018/9/19 11:24
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return "I'm provider";
    }
}
