package com.fly.springboot.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fly.springboot.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author fly
 * @date 2018/7/2 23:42
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeActiveRecordTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeActiveRecordTest.class);

    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setLastName("宋老师");
        employee.setGender("1");
        employee.setAge(35);

        boolean insert = employee.insert();
        Assert.assertTrue(insert);
        LOGGER.debug("**************************insert: {}****************", insert);
    }

    @Test
    public void testIUpdate(){
        Employee employee = new Employee();
        employee.setId(12);
        employee.setLastName("宋老师");
        employee.setEmail("sls@163.com");
        employee.setGender("1");
        employee.setAge(65);

        boolean update = employee.updateById();
        Assert.assertTrue(update);
        LOGGER.debug("**************************updateById: {}****************", update);
    }

    @Test
    public void testSelectAll(){
        Employee employee = new Employee();
        List<Employee> employees = employee.selectAll();
        Assert.assertTrue(employees.size() > 0);
        LOGGER.debug("**************************employees: {}****************", employees);
    }

    @Test
    public void testSelect(){
        Employee employee = new Employee();
        List<Employee> employees = employee.selectList(new EntityWrapper<Employee>()
                .like("last_name", "老师")
        );
        Assert.assertTrue(employees.size() > 0);
        LOGGER.debug("**************************employees: {}****************", employees);
    }

    @Test
    public void testSelectPage(){
        Employee employee = new Employee();
        Page<Employee> employeePage = employee.selectPage(new Page<Employee>(1, 1), new EntityWrapper<Employee>()
                .like("last_name", "Tom")
        );
        List<Employee> records = employeePage.getRecords();
        LOGGER.debug("**************************records: {}****************", records);
    }

    @Test
    public void testDelete(){
        Employee employee = new Employee();
        employee.setId(12);
        boolean delete = employee.deleteById();
        Assert.assertTrue(delete);
        LOGGER.debug("**************************delete: {}****************", delete);
    }

    @Test
    public void testDeleteId(){
        Employee employee = new Employee();
        boolean delete = employee.deleteById(13);
        Assert.assertTrue(delete);
        LOGGER.debug("**************************delete: {}****************", delete);
    }

}
