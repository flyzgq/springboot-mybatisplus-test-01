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
public class SpringbootMybatisplusTestAutoCoreApplicationTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootMybatisplusTestAutoCoreApplicationTests.class);
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
        employee.setGender("1");
        employee.setAge(22);
        employee.setVersion(1);
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
        employee.setGender("0");
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
        employee.setGender("0");
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
        employee.setGender("1");
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
        Integer integer = employeeMapper.deleteById(3);
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

    @Test
    public void testEntityMapperSelect(){
        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(2, 2),
                new EntityWrapper<Employee>()
                        .between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("last_name", "mp")
        );

        LOGGER.debug("********************employees : {}*********************", employees);
    }

    /*SELECT
            id,
    last_name AS lastName,
    email,
    gender,
    age
            FROM
    tbl_employee
    WHERE
            (
                    gender = 0
                    AND last_name LIKE '%m%'
                    OR email LIKE '%163%'
            )*/

    @Test
    public void testSelectList(){
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 0)
                .like("last_name", "m")
                .or()
                .like("email", "163")
        );
        LOGGER.debug("********************employees : {}*********************", employees);
    }


    /*SELECT
            id,
    last_name AS lastName,
    email,
    gender,
    age
            FROM
    tbl_employee
    WHERE
            (
                    gender = 0
                    AND last_name LIKE '%m%'
            )
    OR (
            email LIKE '%163%'
    )*/
    @Test
    public void testSelectListORNew(){
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 0)
                .like("last_name", "m")
                .orNew()
                .like("email", "163")
        );
        LOGGER.debug("********************employees : {}*********************", employees);
    }

    @Test
    public void testEntityWrapper(){
        Employee employee = new Employee();
        employee.setLastName("苍老师");
        employee.setEmail("mptest@163.com");
        employee.setGender("0");
        Integer update = employeeMapper.update(employee,
                new EntityWrapper<Employee>()
                        .eq("last_name", "苍老师")
                        .eq("age", 22)
        );

        Assert.assertTrue(update > 0);
        LOGGER.debug("********************update: {}**************************", update);
    }


    @Test
    public void testEntityWrapperDelete(){
        Integer delete = employeeMapper.delete(new EntityWrapper<Employee>()
                .eq("last_name", "苍老师")
                .eq("age", 22)
        );

        LOGGER.debug("**********************delete: {}***********************", delete);
    }

    /**
     * 默认升序
     */
    @Test
    public void testOrder(){
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 1)
                .orderBy("age")
        );

        LOGGER.debug("***********************employees: {}****************************", employees);
    }

    @Test
    public void testOrderDesc(){
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 1)
                .orderDesc(Arrays.asList("age"))
        );

        LOGGER.debug("***********************employees: {}****************************", employees);
    }

    /**
     * 默认升序
     */
    @Test
    public void testOrderLast(){
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 1)
                .orderBy("age")
                .last("desc limit 1, 2")//有sql注入风险
        );

        LOGGER.debug("***********************employees: {}****************************", employees);
    }
}
