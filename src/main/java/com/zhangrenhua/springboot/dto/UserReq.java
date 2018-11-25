package com.zhangrenhua.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author zhangrenhua
 * @title
 * @desc
 * @date 2018/11/23
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {
    
    private String id;
    
    @NotBlank(message = "编码不能为空")
    private String code;
    
    @NotBlank(message = "名称不能为空")
    private String name;
    
}