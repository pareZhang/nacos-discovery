package com.zjm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @Author pareZhang
 * @Date 2021/3/7 22:27
 **/
@RestController
public class RestConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    //ָ��������
    String serviceId="nacos-restful-provider";
    @GetMapping(value = "/service")
    public String service(){
        String result = restTemplate.getForObject("http://" + serviceId + "/service", String.class);
        return "consumer | invoke " + result;
    }
   /**
    * �ô�д������������Ҫע�͵�@LoadBalancedע��
    @RequestMapping(value = "/service1",method = RequestMethod.GET)
    public String service1(){
        //����һ����ַ
        ServiceInstance serviceInstance=loadBalancerClient.choose(serviceId);
        URI uri=serviceInstance.getUri();
        String result1=restTemplate.getForObject(uri+"/service",String.class);
        return "consumer invoke | "+result1;
    }**/

}
