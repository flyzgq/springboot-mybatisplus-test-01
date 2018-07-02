package com.fly.springboot.mapper;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.fly.springboot.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author fly
 * @date 2018/7/2 22:23
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeMapperTest.class);
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testConditio() {
        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(1, 2),
                Condition.create()
                .between("age", 18, 50)
                        .eq("gender", 1));
        LOGGER.debug("*********************list: {}*****************", list);
    }

}
