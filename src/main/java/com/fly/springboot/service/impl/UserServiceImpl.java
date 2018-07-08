package com.fly.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fly.springboot.entity.User;
import com.fly.springboot.mapper.UserMapper;
import com.fly.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author fly
 * @date 2018/7/8 17:27
 * @description
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
