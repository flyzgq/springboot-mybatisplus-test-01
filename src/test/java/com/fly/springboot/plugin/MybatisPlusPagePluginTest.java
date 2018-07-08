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
 * @date 2018/7/8 9:42
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusPagePluginTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(MybatisPlusPagePluginTest.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 测试创建
     */
    @Test
    public void testPage(){
        Page<Employee> page = new Page<>(2, 1);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        page.setRecords(employees);
        LOGGER.debug("******************employees: {}********************", employees);

        LOGGER.debug("**************************获取分页的相关信息*****************************************");
        LOGGER.debug("**************************总条数: {}***************************", page.getTotal());
        LOGGER.debug("**************************当前页码: {}**************************", page.getCurrent());
        LOGGER.debug("**************************总页码: {}**************************", page.getPages());
        LOGGER.debug("**************************每页显示的条数: {}**************************", page.getSize());
        LOGGER.debug("**************************是否有上一页: {}**************************", page.hasPrevious());
        LOGGER.debug("**************************是否有下一页: {}**************************", page.hasNext());
        LOGGER.debug("**************************查询结果: {}******************************", page.getRecords());
    }
}
