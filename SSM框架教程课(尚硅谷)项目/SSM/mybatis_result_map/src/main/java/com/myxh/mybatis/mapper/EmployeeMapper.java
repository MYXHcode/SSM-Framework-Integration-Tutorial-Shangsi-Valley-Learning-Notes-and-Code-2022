package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/14
 */
public interface EmployeeMapper
{
    /**
     * 根据 id 查询员工信息
     *
     * @param employeeId 员工 id
     * @return 一个员工信息
     */
    Employee getEmployeeByEmployeeId(@Param("employeeId") Integer employeeId);

    /**
     * 根据 id 获取员工信息以及所对应的部门信息
     *
     * @param employeeId 员工 id
     * @return 一个员工信息以及所对应的部门信息
     */
    Employee getEmployeeAndDepartmentByEmployeeId(@Param("employeeId") Integer employeeId);

    /**
     * 通过分步查询查询员工信息以及所对应的部信息的第一步
     *
     * @param employeeId 员工 id
     * @return 一个员工信息
     */
    Employee getEmployeeAndDepartmentByStepOne(@Param("employeeId") Integer employeeId);

    /**
     * 通过分步查询查询部门信息以及部门中的所有员工信息的第二步
     *
     * @param departmentId 部门 id
     * @return 一个部门中的所有员工信息
     */
    List<Employee> getDepartmentAndEmployeeByStepTwo(@Param("departmentId") Integer departmentId);
}
