package com.zhangrenhua.springboot.controller;

import com.zhangrenhua.springboot.aop.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangrenhua
 * @title
 * @desc
 * @date 2018/12/1
 */
@RestController
public class LogController {
    
    /**
     * 简单方法示例
     * @param hello
     * @return
     */
    @RequestMapping("/aop")
    @Log(value="请求了aopDemo方法")
    public String aopDemo(String hello) {
        return "请求参数为：" + hello;
    }
    
    /**
     * 不拦截日志示例
     * @param hello
     * @return
     */
    @RequestMapping("/notaop")
    @Log(ignore=true)
    public String notAopDemo(String hello) {
        return "此方法不记录日志，请求参数为：" + hello;
    }
}
