package com.zjm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author pareZhang
 * @Date 2021/3/7 22:25
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SpringRestConsumerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringRestConsumerBootstrap.class);
    }
    /**
     *  @LoadBalanced 注解，开启 @LoadBalanced 与 Ribbon 的集成
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
