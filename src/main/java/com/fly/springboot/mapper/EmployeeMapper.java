package com.fly.springboot.mapper;

import com.fly.springboot.entity.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author flyzgq
 * @since 2018-07-08
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     *
     * @return
     */
    int deleteAll();


}
