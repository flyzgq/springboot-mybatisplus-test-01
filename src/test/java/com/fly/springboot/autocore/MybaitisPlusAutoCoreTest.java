package com.fly.springboot.autocore;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fly
 * @date 2018/7/7 22:57
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybaitisPlusAutoCoreTest {

    @Test
    public void testAutoCore(){
        /*1.全局配置*/
        GlobalConfig config = new GlobalConfig();
        /*是否支持ActiveRecord模式*/
        config.setActiveRecord(true)
        /*设置作者*/
        .setAuthor("flyzgq")
        /*生成路径*/
        .setOutputDir("D:\\IdeaProjects\\mybatisplus\\springboot-mybatisplus-test-autocore\\src\\main\\java")
        /*设置文件覆盖*/
        .setFileOverride(true)
        /*主键策略 数据库ID自增*/
        .setIdType(IdType.AUTO)
        /*设置生成的service接口的名字的首字母是否为I, 默认的格式IEmployeeService*/
        .setServiceName("%sService")
        /*生成结果映射*/
        .setBaseResultMap(true)
        /*生成sql片段*/
        .setBaseColumnList(true)
        ;

        //2.数据源的配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        /*设置数据库类型,mysql*/
        dataSourceConfig.setDbType(DbType.MYSQL)
        .setDriverName("com.mysql.jdbc.Driver")
        .setUrl("jdbc:mysql://127.0.0.1:3306/mybatisplus")
        .setUsername("root")
        .setPassword("mysql")
        ;


        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        /*全局大写命名*/
        strategyConfig.setCapitalMode(true)
        /*指定表名字段名是否使用下划线*/
        .setDbColumnUnderline(true)
        /*下划线转驼峰命名*/
        .setNaming(NamingStrategy.underline_to_camel)
        /*表名前缀*/
        .setTablePrefix("tbl_")
        /*生成的表*/
        .setInclude("tbl_employee")
        ;

        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        /*设置根路径*/
        packageConfig.setParent("com.fly.springboot")
        /*设置mapper接口的包名*/
        .setMapper("mapper")
        .setService("service")
        .setController("controller")
        .setEntity("entity")
        .setXml("mapper")
        ;

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
        .setDataSource(dataSourceConfig)
        .setStrategy(strategyConfig)
        .setPackageInfo(packageConfig)
        ;

        //6.执行
        autoGenerator.execute();
    }
}
