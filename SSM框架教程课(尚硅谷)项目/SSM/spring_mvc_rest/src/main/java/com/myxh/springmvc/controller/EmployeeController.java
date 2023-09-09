package com.myxh.springmvc.controller;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description
 * 查询所有的员工信息：/employee -> GET
 * 跳转到添加页面：/to/add -> GET
 * 添加员工信息：/employee -> POST
 * 跳转到修改页面：/employee/1 -> GET
 * 修改员工信息：/employee -> PUT
 * 根据 id 删除员工信息：/employee/1 -> DELETE
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);

        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee)
    {
        // 保存员工信息
        employeeDao.save(employee);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.GET)
    public String toUpdate(Model model,@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 查询员工信息
        Employee employee = employeeDao.get(employeeId);

        // 将员工信息在请求域中共享
        model.addAttribute("employee", employee);

        // 跳转到修改页面
        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee)
    {
        // 修改员工信息
        employeeDao.save(employee);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 删除员工信息
        employeeDao.delete(employeeId);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }
}
