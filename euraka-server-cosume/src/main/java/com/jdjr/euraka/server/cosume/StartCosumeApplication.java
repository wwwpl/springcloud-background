package com.jdjr.euraka.server.cosume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangfei52
 * @date 2018年9月19日11:31:38
 */
@EnableEurekaClient
@SpringBootApplication
public class StartCosumeApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(StartCosumeApplication.class, args);
    }
}
