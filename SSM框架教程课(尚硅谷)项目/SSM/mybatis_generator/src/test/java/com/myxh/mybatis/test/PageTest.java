package com.myxh.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxh.mybatis.mapper.EmployeeMapper;
import com.myxh.mybatis.pojo.Employee;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/15
 */
public class PageTest
{
    /**
     * pageInfo = PageInfo{
     * pageNum=1,
     * pageSize=5,
     * size=5,
     * startRow=1,
     * endRow=5,
     * total=30,
     * pages=6,
     * list=Page{
     * count=true,
     * pageNum=1,
     * pageSize=5,
     * startRow=0,
     * endRow=5,
     * total=30,
     * pages=6,
     * reasonable=false,
     * pageSizeZero=false
     * }
     * [Employee{employeeId=1, employeeName='MYXH', age=21, gender='男', email='1735350920@qq.com', departmentId=1}, Employee{employeeId=2, employeeName='张三', age=20, gender='男', email='zhangsan@qq.com', departmentId=1}, Employee{employeeId=3, employeeName='李四', age=22, gender='男', email='lisi@qq.com', departmentId=2}, Employee{employeeId=4, employeeName='王五', age=23, gender='男', email='wangwu@qq.com', departmentId=2}, Employee{employeeId=5, employeeName='赵六', age=24, gender='男', email='zhaoliu@qq.com', departmentId=3}],
     * prePage=0,
     * nextPage=2,
     * isFirstPage=true,
     * isLastPage=false,
     * hasPreviousPage=false,
     * hasNextPage=true,
     * navigatePages=5,
     * navigateFirstPage=1,
     * navigateLastPage=5,
     * navigatepageNums=[1, 2, 3, 4, 5]}
     */
    @Test
    public void testPage()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 5);

        List<Employee> employeeList = mapper.selectByExample(null);

        // 查询功能之后可以获取分页相关的所有数据
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList, 5);

        System.out.println("结果：");
        employeeList.forEach(System.out::println);
        System.out.println("page = " + page);
        System.out.println("pageInfo = " + pageInfo);

        sqlSession.close();
    }
}
