package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.DynamicSqlMapper;
import com.myxh.mybatis.pojo.Employee;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/14
 */
public class DynamicSqlMapperTest
{
    @Test
    public void testGetEmployeeByCondition()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Employee employee = new Employee(null, "MYXH", 21, "男", "1735350920@qq.com");
        List<Employee> employeeList = mapper.getEmployeeByCondition(employee);
        System.out.println("结果：");
        employeeList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetEmployeeByChoose()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Employee employee = new Employee(null, "MYXH", 21, "男", "1735350920@qq.com");
        List<Employee> employeeList = mapper.getEmployeeByChoose(employee);
        System.out.println("结果：");
        employeeList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsertMoreEmployee()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Employee employee1 = new Employee(null, "test1", 18, "男", "test1@qq.com");
        Employee employee2 = new Employee(null, "test2", 18, "男", "test2@qq.com");
        Employee employee3 = new Employee(null, "test3", 18, "男", "test3@qq.com");
        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3);
        int result = mapper.insertMoreEmployee(employeeList);
        System.out.println("结果：" + result);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreEmployee()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] employeeIds = new Integer[]{7, 8};
        int result = mapper.deleteMoreEmployee(employeeIds);
        System.out.println("结果：" + result);
        sqlSession.close();
    }
}
