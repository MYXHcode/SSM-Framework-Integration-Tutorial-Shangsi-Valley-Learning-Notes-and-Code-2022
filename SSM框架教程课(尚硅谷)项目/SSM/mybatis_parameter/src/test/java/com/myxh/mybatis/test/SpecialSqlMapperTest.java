package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.SpecialSqlMapper;
import com.myxh.mybatis.pojo.User;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/13
 */
public class SpecialSqlMapperTest
{
    @Test
    public void testGetUserByLikeUsername()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> userList = mapper.getUserByLikeUsername("a");
        System.out.println("结果：");
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreUserByIds()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        int result = mapper.deleteMoreUserByIds("4,5");
        System.out.println("结果：" + result);
        sqlSession.close();
    }

    @Test
    public void testGetUserByTableNameToList()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> userList = mapper.getUserByTableNameToList("t_user");
        System.out.println("结果：");
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsertUser()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "test", "test", 18, "男", "test@qq.com");
        int result = mapper.insertUser(user);
        System.out.println("结果：" + result);
        System.out.println("用户信息：" + user);
        sqlSession.close();
    }

    @Test
    public void testJDBC()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "MYXH", "520.ILY!");
            /*
            String sql = "select * from t_user where username like '%?%'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // preparedStatement.setString(1, "a");
             */

            String sql = "insert into t_user (id, username, password, age, gender, email)" +
                    "values (null, 'test', 'test', 18, '男', 'test@qq.com');";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);
            System.out.println("id = " + id);

            // ...

            preparedStatement.close();
            connection.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
