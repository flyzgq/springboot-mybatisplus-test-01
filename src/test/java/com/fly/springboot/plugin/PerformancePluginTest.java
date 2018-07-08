package com.fly.springboot.plugin;

import com.baomidou.mybatisplus.plugins.Page;
import com.fly.springboot.entity.Employee;
import com.fly.springboot.mapper.EmployeeMapper;
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
 * @date 2018/7/8 13:12
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PerformancePluginTest {


    public static final Logger LOGGER = LoggerFactory.getLogger(PerformancePluginTest.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * sql性能插件
     */
    @Test
    public void testPerformace(){
        Page<Employee> page = new Page<>(2, 1);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        page.setRecords(employees);
        LOGGER.debug("**************************total: {}*********", page.getTotal());
        LOGGER.debug("**************************records: {}*******", page.getRecords());
    }
}
