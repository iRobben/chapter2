package com.zhangrenhua.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://blog.lqdev.cn", maxAge = 3600)
@RestController
public class CorsController {
    
    @GetMapping("/cors")
    public String index(){
        return "hello,CORS";
    }
}