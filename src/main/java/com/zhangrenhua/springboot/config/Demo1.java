package com.zhangrenhua.springboot.config;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhangrenhua
 * @title
 * @desc
 * @date 2018/11/23
 */

@Data
public class Demo1 {
    
    @NotEmpty(message = "名字不能为空")
    private String name;
    
    @NotEmpty(message = "年龄不能为空")
    private String age;
    
    
}
