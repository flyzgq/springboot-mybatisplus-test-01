package com.fly.springboot.service.impl;

import com.fly.springboot.entity.Employee;
import com.fly.springboot.mapper.EmployeeMapper;
import com.fly.springboot.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author flyzgq
 * @since 2018-07-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    /*
    * 1.不再进行mapper的注入，ServiceImpl已经注入了
    * 2.ServiceImpl提供常用的方法
    * */
}
