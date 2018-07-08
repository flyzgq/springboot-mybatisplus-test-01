package com.fly.springboot.plugin;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fly.springboot.entity.Employee;
import com.fly.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fly
 * @date 2018/7/8 13:32
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptimisticLockerPluginTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(OptimisticLockerPluginTest.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testOptimisticLocker(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Herry");
        employee.setVersion(2);
        Integer update = employeeMapper.updateById(employee);
        LOGGER.debug("*****************update: {}**************",update);
    }
}
