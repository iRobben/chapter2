package com.zhangrenhua.springboot.service.impl;

import com.zhangrenhua.springboot.entity.User;
import com.zhangrenhua.springboot.dao.UserDao;
import com.zhangrenhua.springboot.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangrenhua
 * @since 2018-11-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
