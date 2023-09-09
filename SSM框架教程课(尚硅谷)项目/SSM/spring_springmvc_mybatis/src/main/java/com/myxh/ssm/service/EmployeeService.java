package com.myxh.ssm.service;

import com.github.pagehelper.PageInfo;
import com.myxh.ssm.pojo.Employee;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 */
public interface EmployeeService
{


    /**
     * 查询所有的员工信息
     *
     * @return 所有员工信息
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param pageNum 当前页的页码
     * @return 员工的分页信息
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
