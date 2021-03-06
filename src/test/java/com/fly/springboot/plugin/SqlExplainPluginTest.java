package com.fly.springboot.plugin;

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
 * @date 2018/7/8 11:52
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlExplainPluginTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SqlExplainPluginTest.class);
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testSqlExplain(){
        /*全表删除操作*/
        Integer delete = employeeMapper.delete(null);
        LOGGER.debug("******************************delete: {}***************", delete);
    }
}
