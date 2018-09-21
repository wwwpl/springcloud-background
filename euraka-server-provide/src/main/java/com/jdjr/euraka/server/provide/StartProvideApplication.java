package com.jdjr.euraka.server.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangfei52
 * @date 2018年9月19日11:21:05
 */
//表明是服务提供者
@EnableEurekaClient
@SpringBootApplication
public class StartProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartProvideApplication.class, args);
    }
}
