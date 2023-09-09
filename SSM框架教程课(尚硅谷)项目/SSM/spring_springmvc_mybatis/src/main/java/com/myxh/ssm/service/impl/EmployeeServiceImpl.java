package com.myxh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxh.ssm.mapper.EmployeeMapper;
import com.myxh.ssm.pojo.Employee;
import com.myxh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询所有的员工信息
     *
     * @return 所有员工信息
     */
    @Override
    public List<Employee> getAllEmployee()
    {
        return employeeMapper.getAllEmployee();
    }

    /**
     * 获取员工的分页信息
     * @param pageNum 当前页的页码
     * @return 员工的分页信息
     */
    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum)
    {
        // 开启分页功能
        PageHelper.startPage(pageNum, 5);

        // 查询所有的员工信息
        List<Employee> employeeList = employeeMapper.getAllEmployee();

        // 获取分页相关数据
        PageInfo<Employee> employeePage = new PageInfo<>(employeeList, 5);

        return employeePage;
    }
}
