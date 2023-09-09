package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/14
 */
public interface DynamicSqlMapper
{
    /**
     * 根据条件查询员工信息
     *
     * @param employee 员工信息的条件
     * @return 一些员工信息
     */
    List<Employee> getEmployeeByCondition(Employee employee);

    /**
     * 使用 choose 查询员工信息
     *
     * @param employee 员工信息的条件
     * @return 一些员工信息
     */
    List<Employee> getEmployeeByChoose(Employee employee);

    /**
     * 批量添加员工信息
     *
     * @param employees 一些员工信息
     * @return 影响的行数
     */
    int insertMoreEmployee(@Param("employees") List<Employee> employees);

    /**
     * 批量删除员工信息
     *
     * @param employeeIds 一些员工 id
     * @return 影响的行数
     */
    int deleteMoreEmployee(@Param("employeeIds") Integer[] employeeIds);

}
