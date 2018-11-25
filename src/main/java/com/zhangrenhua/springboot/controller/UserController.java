package com.zhangrenhua.springboot.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zhangrenhua.springboot.dto.UserReq;
import com.zhangrenhua.springboot.dto.UserResp;
import com.zhangrenhua.springboot.entity.User;
import com.zhangrenhua.springboot.exception.CommonException;
import com.zhangrenhua.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangrenhua
 * @since 2018-11-23
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("add")
    public Map<String,String> addUser(@Valid @RequestBody UserReq userReq){
        User user = new User();
        user.setCode(userReq.getCode());
        user.setName(userReq.getName());
        userService.insert(user);
        Map<String,String> result = new HashMap<>();
        result.put("respCode", "01");
        result.put("respMsg", "新增成功");
        return result;
    }
    
    @PostMapping("update")
    public Map<String,String> updateUser(@Valid @RequestBody UserReq userReq){
        
        User user = new User();
        user.setCode(userReq.getCode());
        user.setName(userReq.getName());
        user.setId(Long.parseLong(userReq.getId()));
        userService.updateById(user);
        Map<String,String> result = new HashMap<String,String>();
        result.put("respCode", "01");
        result.put("respMsg", "更新成功");
        return result;
    }
    
    @GetMapping("/get/{id}")
    public Map<String,Object> getUser(@PathVariable("id") String id){
        //查询
        User user = userService.selectById(id);
        if(user == null) {
            throw new CommonException("0001", "用户ID：" + id + "，未找到");
        }
        UserResp resp = UserResp.builder()
                .id(user.getId().toString())
                .code(user.getCode())
                .name(user.getName())
                .status(user.getStatus())
                .build();
        Map<String,Object> result = new HashMap<>();
        result.put("respCode", "01");
        result.put("respMsg", "成功");
        result.put("data", resp);
        return result;
    }
    
    @GetMapping("/page")
    public Map<String,Object> pageUser(int current, int size){
        //分页
        Page<User> page = new Page<>(current, size);
        Map<String,Object> result = new HashMap<>();
        result.put("respCode", "01");
        result.put("respMsg", "成功");
        result.put("data", userService.selectPage(page));
        return result;
    }

}

