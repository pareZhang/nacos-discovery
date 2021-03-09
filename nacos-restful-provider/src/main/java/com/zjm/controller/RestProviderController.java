package com.zjm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author pareZhang
 * @Date 2021/3/7 22:02
 **/
@RestController
public class RestProviderController {
    //暴露一个restful接口
    @GetMapping(value = "/service")
    public String service(){
        System.out.println("provider invoke");
        return "provider invoke";
    }
}
