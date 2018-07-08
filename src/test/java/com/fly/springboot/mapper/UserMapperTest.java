package com.fly.springboot.mapper;

import com.fly.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fly
 * @date 2018/7/8 17:29
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 逻辑删除
     */
    @Test
    public void testLogicDelete(){
        Integer integer = userMapper.deleteById(3);
        LOGGER.debug("************************delete: {}*********************", integer);
    }

    /**
     * 查询过滤掉逻辑删除的结果
     */
    @Test
    public void testSelect(){
        User user = userMapper.selectById(1);
        LOGGER.debug("**************************user: {}**********************", user);
    }

    /**
     * 插入填充测试
     */
    @Test
    public void testInsertMetaObjectHandler(){
        User user = new User();
        user.setName("tom");
        user.setLogicFlag(1);
        this.userMapper.insert(user);
    }

    /**
     * 更新填充测试
     */
    @Test
    public void testUpdateMetaObjectHandler(){
        User user = new User();
        user.setId(6);
        user.setLogicFlag(1);
        this.userMapper.updateById(user);
    }
}
