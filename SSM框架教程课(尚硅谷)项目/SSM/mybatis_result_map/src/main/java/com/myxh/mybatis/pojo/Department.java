package com.myxh.mybatis.pojo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/14
 */
public class Department
{
    private Integer departmentId;
    private String departmentName;
    private String email;

    private List<Employee> employees;

    public Department()
    {

    }

    public Department(Integer departmentId, String departmentName, String email, List<Employee> employees)
    {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.email = email;
        this.employees = employees;
    }

    public Integer getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }

    @Override
    public String toString()
    {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", email='" + email + '\'' +
                ", employees=" + employees +
                '}';
    }
}
