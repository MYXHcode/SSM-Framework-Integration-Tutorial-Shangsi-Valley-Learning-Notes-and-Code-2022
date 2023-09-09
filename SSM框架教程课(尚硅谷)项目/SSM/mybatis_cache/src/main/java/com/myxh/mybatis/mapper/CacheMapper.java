package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @author MYXH
 * @date 2023/8/15
 */
public interface CacheMapper
{
    /**
     * 根据员工 id 查询员工信息
     *
     * @param employeeId 员工 id
     * @return 一个员工信息
     */
    Employee getEmployeeByEmployeeId(@Param("employeeId") Integer employeeId);

    /**
     * 添加员工信息
     *
     * @param employee 一个员工信息
     * @return 影响的行数
     */
    int insertEmployee(@Param("employee") Employee employee);
}
