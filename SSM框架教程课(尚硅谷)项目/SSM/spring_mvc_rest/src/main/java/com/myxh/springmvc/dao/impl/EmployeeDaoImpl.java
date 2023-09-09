package com.myxh.springmvc.dao.impl;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/2
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
    private static final Map<Integer, Employee> employees;

    static
    {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "MYXH", 21, "男", "1735350920@qq.com"));
        employees.put(2, new Employee(2, "张三", 20, "男", "zhangsan@qq.com"));
        employees.put(3, new Employee(3, "李四", 22, "男", "lisi@qq.com"));
        employees.put(4, new Employee(4, "王五", 23, "男", "wangwu@qq.com"));
        employees.put(5, new Employee(5, "赵六", 24, "男", "zhaoliu@qq.com"));
    }

    private static Integer initId = 6;

    public void save(Employee employee)
    {
        if (employee.getEmployeeId() == null)
        {
            employee.setEmployeeId(initId++);
        }
        employees.put(employee.getEmployeeId(), employee);
    }

    public Collection<Employee> getAll()
    {
        return employees.values();
    }

    public Employee get(Integer id)
    {
        return employees.get(id);
    }

    public void delete(Integer id)
    {
        employees.remove(id);
    }
}
