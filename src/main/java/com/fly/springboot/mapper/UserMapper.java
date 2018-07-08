package com.fly.springboot.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fly.springboot.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author fly
 * @date 2018/7/8 17:25
 * @description
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
}
