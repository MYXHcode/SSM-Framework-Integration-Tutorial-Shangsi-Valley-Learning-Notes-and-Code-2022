package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.UserMapper;
import com.myxh.mybatis.pojo.User;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/8/13
 */
public class ParameterTest
{
    @Test
    public void testGetUserByUsername()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("MYXH");
        System.out.println("结果：" + user);
        sqlSession.close();
    }

    @Test
    public void testCheckLogin()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("MYXH", "520.ILY!");
        System.out.println("结果：" + user);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByUserMap()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", "MYXH");
        userMap.put("password", "520.ILY!");
        User user = mapper.checkLoginByUserMap(userMap);
        System.out.println("结果：" + user);
        sqlSession.close();
    }

    @Test
    public void testInsertUser()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "MYXH", "520.ILY!", 21, "男", "1735350920@qq.com");
        int result = mapper.insertUser(user);
        System.out.println("结果：" + result);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByUserParam()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByUserParam("MYXH", "520.ILY!");
        System.out.println("结果：" + user);
        sqlSession.close();
    }
}
