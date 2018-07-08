package com.fly.springboot.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author fly
 * @date 2018/7/8 14:51
 * @description: 自定义全局操作，在application.yml中配置自定义SQL注入器
 **/
public class Myinjector extends AutoSqlInjector {

    /**
     * 自定义方法，注入点（子类需重写该方法）
     *
     * @param configuration
     * @param builderAssistant
     * @param mapperClass
     * @param modelClass
     * @param table
     */
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        /*
        * 1.将EmployeeMapper中定义的deleteAll,处理成对应的MapperedStatement对象
        * 2.加人到configuration对象中
        **/

        /*注入的sql语句*/
        String sql = "delete from "+ table.getTableName();
        /*注入方法名， 一定要与EmployeeMapper接口中的方法名一致*/
        String method = "deleteAll";

        /*构造sqlSource对象*/
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}
