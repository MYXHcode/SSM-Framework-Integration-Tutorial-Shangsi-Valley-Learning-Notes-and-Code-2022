package com.myxh.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.myxh.ssm.pojo.Employee;
import com.myxh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 * @description
 * 查询所有的员工信息：/employee -> GET
 * 查询员工的分页信息：/employee/page/1 -> GET
 * 根据 id 查询员工信息：/employee/1 -> GET
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
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        List<Employee> employeeList = employeeService.getAllEmployee();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("employeeList", employeeList);

        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model)
    {
        // 获取员工的分页信息
        PageInfo<Employee> employeePage = employeeService.getEmployeePage(pageNum);

        // 将分页数据共享到请求域中
        model.addAttribute("employeePage", employeePage);

        // 跳转到列表页面
        return "employee_list";
    }
}
