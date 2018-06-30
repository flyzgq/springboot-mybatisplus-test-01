package com.fly.springboot;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fly.springboot.entity.Employee;
import com.fly.springboot.mapper.EmployeeMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisplusTest01ApplicationTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootMybatisplusTest01ApplicationTests.class);
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testCommonInsert(){
        Employee employee = new Employee();
        employee.setLastName("mp");
        employee.setEmail("mp@163.com");
//        employee.setGender(1);
//        employee.setAge(22);
        //insert 方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现在SQL语句中
        Integer insert = employeeMapper.insert(employee);
        LOGGER.debug("*******************************key : {}********************", employee.getId());
        Assert.assertTrue(insert >0);
    }

    @Test
    public void testCommonAllInsert(){
        Employee employee = new Employee();
        employee.setLastName("mp");
        employee.setEmail("mp@163.com");
//        employee.setGender(1);
//        employee.setAge(22);
        //insertAllColumn 方法在插入时， 不管属性是否为空，属性对应的字段都会出现在SQL语句中
        Integer insert = employeeMapper.insertAllColumn(employee);
        LOGGER.debug("*******************************key : {}********************", employee.getId());
        Assert.assertTrue(insert >0);
    }

    @Test
    public void testUpdateById(){
        Employee employee = new Employee();
        employee.setId(20);
        employee.setLastName("mybatis");
        employee.setEmail("mybatis@163.com");
        employee.setGender(0);
        employee.setAge(33);
        Integer integer = employeeMapper.updateById(employee);
        Assert.assertTrue(integer > 0);
    }

    @Test
    public void testUpdateAllColumnById(){
        Employee employee = new Employee();
        employee.setId(20);
        employee.setLastName("mybatis");
        employee.setEmail("mybatis@163.com");
        employee.setGender(0);
//        employee.setAge(33);
        Integer integer = employeeMapper.updateAllColumnById(employee);
        Assert.assertTrue(integer > 0);
    }

    @Test
    public void testSelectById(){
        Employee employee = employeeMapper.selectById(20);
        LOGGER.info("*****************************testSelectById: {}", employee);
    }

    @Test
    public void testSelectOne(){
        Employee employee = new Employee();
        employee.setId(17);
        employee.setLastName("mp");
        employee.setGender(1);
        Employee selectOne = employeeMapper.selectOne(employee);
        LOGGER.info("****************************testSelectOne:{}*************", selectOne);
    }

    @Test
    public void testSelectBatchIds(){
        List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList("4", "5", "6"));
        LOGGER.info("**********************************selectBatchIds: {}*****************", employees);
    }

    @Test
    public void testSelectByMap(){
        Map<String, Object> colummMap = new HashMap<>();
        colummMap.put("last_name", "mp");
        List<Employee> employeeList = employeeMapper.selectByMap(colummMap);
        LOGGER.info("************************testSelectByMap: {}**************************", employeeList);
    }

    @Test
    public void testSelectPage(){
        List<Employee> employees = employeeMapper.selectPage(
                new Page<Employee>(2, 13),
                new EntityWrapper<Employee>(new Employee())
                        .eq("last_name", "mp")
        );
        LOGGER.info("********************************testSelectPage: {}, size：{}", employees, employees.size());
    }

    @Test
    public void testDeleteById(){
        Integer integer = employeeMapper.deleteById(14);
        Assert.assertTrue(integer > 0);
    }

    @Test
    public void testDeleteBybatch(){
        Integer integer = employeeMapper.deleteBatchIds(Arrays.asList("21", "22"));
        Assert.assertTrue(integer > 0);
    }

    @Test
    public void testdeleteByMap(){
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("last_name", "mp");
        Integer integer = employeeMapper.deleteByMap(conditionMap);
        Assert.assertTrue(integer > 0);
    }

    @Test
    public void testDelete(){
        employeeMapper.delete(new EntityWrapper<Employee>().eq("last_name", "mp"));
    }
}
