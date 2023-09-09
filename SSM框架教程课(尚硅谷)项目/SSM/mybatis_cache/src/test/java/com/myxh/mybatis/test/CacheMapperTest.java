package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.CacheMapper;
import com.myxh.mybatis.pojo.Employee;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author MYXH
 * @date 2023/8/15
 */
public class CacheMapperTest
{
    /**
     * MyBatis 的一级缓存：
     * MyBatis 的一级缓存是 sglSession 级别的，即通过同一个 sgLSession 查询的数据会被缓存
     * 再次使用同一个 sqlSession 查询同一条数据，会从缓存中获取
     * 使一级缓存失效的四种情况：
     * 1、不同的 sqlSession 对应不同的一级缓存
     * 2、同一个 sqlSession 但是查询条件不同
     * 3、同一个 sqlSession 两次查询期间执行了任何一次增删改操作
     * 4、同一个 sqlSession 两次查询期间手动清空了缓存
     */
    @Test
    public void testGetEmployeeByEmployeeId()
    {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Employee employee1 = mapper1.getEmployeeByEmployeeId(1);
        System.out.println("结果 1：" + employee1);

        /*
        Employee employee = new Employee(null, "test4", 18, "男", "test4@qq.com");
        int result = mapper1.insertEmployee(employee);
        System.out.println("结果 2：" + result);
         */

        sqlSession1.clearCache();

        Employee employee2 = mapper1.getEmployeeByEmployeeId(1);
        System.out.println("结果 3：" + employee2);

        /*
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Employee employee3 = mapper2.getEmployeeByEmployeeId(1);
        System.out.println("结果 4：" + employee3);
         */

        sqlSession1.close();
        // sqlSession2.close();
    }

    /**
     * MyBatis 的二级缓存：
     * MyBatis 的二级缓存是 sqlSessionFactory 级别的，即通过同一个 sqlSessionFactory 所获取的 sqLSession 对象查询的数据会被缓存
     * 在通过同一个 sqlSessionFactory 所获取的 sqlSession 查询相同的数据会从缓存中获取
     * MyBatis 二级缓存开启的条件：
     * 1、在核心配置文件中，设置全局配置属性 cacheEnabled="true"，默认为 true，不需要设置
     * 2、在映射文件中设置标签 <cache/>
     * 3、二级缓存必须在 sqlSession 关闭或提交之后有效
     * 4、查询的数据所转换的实体类类型必须实现序列化的接口
     * 使二级缓存失效的情况：
     * 两次查询之间执行了任意的增删改操作，会使一级和二级缓存同时失效
     *
     * @throws IOException IO 异常
     */
    @Test
    public void testCache() throws IOException
    {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Employee employee1 = mapper1.getEmployeeByEmployeeId(1);
        System.out.println("结果 1：" + employee1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2= sqlSession2.getMapper(CacheMapper.class);
        Employee employee2 = mapper2.getEmployeeByEmployeeId(1);
        System.out.println("结果 2：" + employee2);
        sqlSession2.close();
    }
}
