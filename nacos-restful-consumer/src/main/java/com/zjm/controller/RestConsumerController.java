package com.zjm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author pareZhang
 * @Date 2021/3/7 22:27
 **/
@RestController
public class RestConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //要进行远程调用，需要知道提供方的ip和端口
    @Value("${provider.address}")
    private String provider;

    @GetMapping(value = "/service")
    public String service(){
        //远程调用
        //RestTemplate restTemplate=new RestTemplate();
        String providerResult =restTemplate.getForObject("http://" +provider+"/service",String.class);
        return "consumer invoke |"+providerResult;
    }
}
