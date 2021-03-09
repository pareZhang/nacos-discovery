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
    //Ҫ����Զ�̵��ã���Ҫ֪���ṩ����ip�Ͷ˿�
    @Value("${provider.address}")
    private String provider;

    @GetMapping(value = "/service")
    public String service(){
        //Զ�̵���
        //RestTemplate restTemplate=new RestTemplate();
        String providerResult =restTemplate.getForObject("http://" +provider+"/service",String.class);
        return "consumer invoke |"+providerResult;
    }
}
