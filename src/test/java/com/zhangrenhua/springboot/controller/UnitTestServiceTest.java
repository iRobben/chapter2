package com.zhangrenhua.springboot.controller;

import com.zhangrenhua.springboot.service.IUserService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 编写接口测试类
 * @author zhangrenhua
 *
 */
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
public class UnitTestServiceTest {
     
    @Autowired
    IUserService userService;
     
    //引入 ContiPerf 进行性能测试
    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();
     
    @Test
    //10个线程 执行10次
    @PerfTest(invocations = 100,threads = 10)
    public void test() {
        String msg = "张人话";
        String result = userService.selectById(1).getName();
        //断言 是否和预期一致
        Assert.assertEquals(msg, result);
    }
}