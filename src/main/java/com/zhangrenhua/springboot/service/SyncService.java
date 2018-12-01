package com.zhangrenhua.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Slf4j
public class SyncService {
    
    @Async("asyncPoolTaskExecutor")
    public Future<String> asyncEvent() throws InterruptedException {
        //休眠1s
        Thread.sleep(1000);
        log.info("异步方法内部线程名称：{}!", Thread.currentThread().getName());
        return new AsyncResult<>("异步方法返回值");
    }
 
    public void syncEvent() throws InterruptedException {
        Thread.sleep(1000);
        //log.info("同步方法输出：{}!", System.currentTimeMillis());
    }
 
}