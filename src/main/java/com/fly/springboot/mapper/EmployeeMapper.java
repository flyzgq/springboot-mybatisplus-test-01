package com.fly.springboot.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fly.springboot.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * @author fly
 * @date 2018/6/30 20:04
 * @description
 **/
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}
