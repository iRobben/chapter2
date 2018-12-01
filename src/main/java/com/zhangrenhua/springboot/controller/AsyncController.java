package com.zhangrenhua.springboot.controller;

import com.zhangrenhua.springboot.service.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@Slf4j
public class AsyncController {
 
    @Autowired
    private SyncService syncService;
    
    @GetMapping("/async")
    public String doAsync() throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("方法执行开始：{}", start);
        //调用同步方法
        syncService.syncEvent();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法用时：{}", syncTime - start);
        //调用异步方法
        Future<String> doFutrue = syncService.asyncEvent();
        while(true) {
            //判断异步任务是否完成
            if(doFutrue.isDone()) {
                break;
            }
            Thread.sleep(100);
        }
        long asyncTime = System.currentTimeMillis();
        log.info("异步方法用时：{}", asyncTime - syncTime);
        log.info("方法执行完成：{}!",asyncTime);
        return "async!!!";
    }
}