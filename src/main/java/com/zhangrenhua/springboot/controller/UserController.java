package com.zhangrenhua.springboot.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zhangrenhua.springboot.dto.UserReq;
import com.zhangrenhua.springboot.dto.UserResp;
import com.zhangrenhua.springboot.entity.User;
import com.zhangrenhua.springboot.exception.CommonException;
import com.zhangrenhua.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

//    @GetMapping("set/{key}/{value}")
//    public String set(@PathVariable("key")String key,@PathVariable("value") String value) {
//        //注意这里的 key不能为null spring 内部有检验
//        redisTemplate.opsForValue().set(key, value);
//        return key + "," + value;
//    }
//
//    @GetMapping("get/{key}")
//    public String get(@PathVariable("key") String key) {
//        return "key=" + key + ",value=" + redisTemplate.opsForValue().get(key);
//    }
    
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
    @Cacheable(value="OKONG",key="#id")
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

