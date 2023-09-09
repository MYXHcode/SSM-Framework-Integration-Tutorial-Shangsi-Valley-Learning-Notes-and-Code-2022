package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.DepartmentMapper;
import com.myxh.mybatis.mapper.EmployeeMapper;
import com.myxh.mybatis.pojo.Department;
import com.myxh.mybatis.pojo.Employee;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author MYXH
 * @date 2023/8/14
 */
public class ResultMapTest
{
    @Test
    public void testGetEmployeeByEmployeeId()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeByEmployeeId(1);
        System.out.println("结果：" + employee);
        sqlSession.close();
    }

    @Test
    public void testGetEmployeeAndDepartmentByEmployeeId()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeAndDepartmentByEmployeeId(1);
        System.out.println("结果：" + employee);
        sqlSession.close();
    }

    @Test
    public void testGetEmployeeAndDepartmentByStep()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeAndDepartmentByStepOne(1);
        System.out.println("结果：" + employee.getEmployeeName());
        sqlSession.close();
    }

    @Test
    public void testGetDepartmentAndEmployeeByDepartmentId()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.getDepartmentAndEmployeeByDepartmentId(1);
        System.out.println("结果：" + department);
        sqlSession.close();
    }

    @Test
    public void testGetDepartmentAndEmployeeByStep()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.getDepartmentAndEmployeeByStepOne(1);
        System.out.println("结果：" + department.getDepartmentName());
        sqlSession.close();
    }
}
