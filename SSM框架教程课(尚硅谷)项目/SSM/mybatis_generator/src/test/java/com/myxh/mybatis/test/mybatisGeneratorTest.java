package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.EmployeeMapper;
import com.myxh.mybatis.pojo.Employee;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author MYXH
 * @date 2023/8/15
 */
public class mybatisGeneratorTest
{
    @Test
    public void testMybatisGenerator()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 根据 id 查询数据
        /*
        Employee employee = mapper.selectByPrimaryKey(1);
        System.out.println("结果：" + employee);
         */

        // 查询所有数据
        /*
        List<Employee> employeeList = mapper.selectByExample(null);
        employeeList.forEach(System.out::println);
         */

        // 根据条件查询数据
        /*
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmployeeNameEqualTo("MYXH").andAgeGreaterThanOrEqualTo(20);
        example.or().andGenderEqualTo("男");
        List<Employee> employeeList = mapper.selectByExample(example);
        employeeList.forEach(System.out::println);
         */

        // 测试普通修改功能
        /*
        Employee employee = new Employee(1, "末影小黑xh", 21, "男" , "1735350920@qq.com", null);
        int result = mapper.updateByPrimaryKey(employee);
        System.out.println("结果：" + result);
         */

        // 测试选择性修改功能
        Employee employee = new Employee(1, "末影小黑xh", 21, "男" , "1735350920@qq.com", null);
        int result = mapper.updateByPrimaryKeySelective(employee);
        System.out.println("结果：" + result);

        sqlSession.close();
    }
}
