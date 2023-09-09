package com.myxh.springmvc.dao;

import com.myxh.springmvc.pojo.Employee;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 */
public interface EmployeeDao
{
    void save(Employee employee);

    Collection<Employee> getAll();

    Employee get(Integer id);

    void delete(Integer id);
}
