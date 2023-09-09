package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.Department;
import org.apache.ibatis.annotations.Param;

/**
 * @author MYXH
 * @date 2023/8/14
 */
public interface DepartmentMapper
{
    /**
     * 通过分步查询查询员工信息以及所对应的部信息的第二步
     *
     * @param departmentId 部门 id
     * @return 一个员工所对应的部门信息
     */
    Department getEmployeeAndDepartmentByStepTwo(@Param("departmentId") Integer departmentId);

    /**
     * 根据 id 获取部门信息以及部门中的所有员工信息
     *
     * @param departmentId 部门 id
     * @return 一个部门信息以及部门中的所有员工信息
     */
    Department getDepartmentAndEmployeeByDepartmentId(@Param("departmentId") Integer departmentId);

    /**
     * 通过分步查询查询部门信息以及部门中的所有员工信息的第一步
     *
     * @param departmentId 部门 id
     * @return 一个部门信息
     */
    Department getDepartmentAndEmployeeByStepOne(@Param("departmentId") Integer departmentId);
}
