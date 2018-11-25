package com.zhangrenhua.springboot.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2018/11/22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

    private String code;

    private String name;

}

