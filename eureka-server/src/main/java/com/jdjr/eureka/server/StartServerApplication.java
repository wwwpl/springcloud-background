package com.jdjr.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangfei52
 * @date 2018年9月18日15:58:03
 */
//注册中心
@EnableEurekaServer
@SpringBootApplication
public class StartServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartServerApplication.class, args);
    }
}
