package com.myxh.ssm.mapper;

import com.myxh.ssm.pojo.Employee;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 */
public interface EmployeeMapper
{
    /**
     * 查询所有的员工信息
     *
     * @return 所有员工信息
     */
    List<Employee> getAllEmployee();
}
