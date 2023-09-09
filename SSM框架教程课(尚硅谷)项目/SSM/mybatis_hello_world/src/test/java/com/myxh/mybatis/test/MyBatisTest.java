package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.UserMapper;
import com.myxh.mybatis.pojo.User;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/11
 */
public class MyBatisTest
{
    @Test
    public void testInsert() throws IOException
    {
        // 获取核心配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取 sqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获取 sqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // 获取 sql 的会话对象 sqlSession(不会自动提交事务)，是 MyBatis 提供的操作数据库的对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取 sql 的会话对象 sqlSession(会自动提交事务)，是 MyBatis 提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取 userMapper 的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用 mapper 接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();

        //提供 sql 以及的唯一标识找到 sqL 并执行，唯一标识是 namespace.sqlId
        // int result = sqlSession.insert("com.myxh.mybatis.mapper.UserMapper.insertUser");

        System.out.println("结果：" + result);

        // 提交事务
        // sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }
    
    @Test
    public void testUpdate()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser();
        System.out.println("结果：" + result);
        sqlSession.close();
    }

    @Test
    public void testDelete()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser();
        System.out.println("结果：" + result);
        sqlSession.close();
    }

    @Test
    public void testGetUserById()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println("结果：" + user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getAllUser();
        System.out.println("结果：");
        userList.forEach(System.out::println);
        sqlSession.close();
    }
}
