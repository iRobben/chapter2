package com.zhangrenhua.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 编写mock测试服务
 * @author zhangrenhua
 *
 */
@RestController
public class DemoController {
 
    @GetMapping("/mock")
    public String demo(String msg) {
        return msg;
    }
}