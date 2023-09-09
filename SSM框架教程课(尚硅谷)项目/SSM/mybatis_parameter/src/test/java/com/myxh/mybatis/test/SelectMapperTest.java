package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.SelectMapper;
import com.myxh.mybatis.pojo.User;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/8/13
 */
public class SelectMapperTest
{
    @Test
    public void testGetUserById()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println("结果：" + user);
        sqlSession.close();
    }

    @Test
     public void testGetAllUser()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = mapper.getAllUser();
        System.out.println("结果：");
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetUserCount()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer userCount = mapper.getUserCount();
        System.out.println("结果：" + userCount);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdToUserMap()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userMap = mapper.getUserByIdToUserMap(1);

        // {password=520.ILY!, gender=男, id=1, age=21, email=1735350920@qq.com, username=MYXH}
        System.out.println("结果：" + userMap);
        sqlSession.close();
    }

    @Test
    public void testGetAllUserToUserMap()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        /*
        List<Map<String, Object>> userList = mapper.getAllUserToUserMap();

        // [{password=520.ILY!, gender=男, id=1, age=21, email=1735350920@qq.com, username=MYXH}, {password=000000, gender=男, id=2, age=21, email=root@qq.com, username=root}, {password=123456, gender=男, id=3, age=21, email=admin@qq.com, username=admin}]
        System.out.println("结果：" + userList);
         */
        Map<String, Object> userMap = mapper.getAllUserToUserMap();
        // {1={password=520.ILY!, gender=男, id=1, age=21, email=1735350920@qq.com, username=MYXH}, 2={password=000000, gender=男, id=2, age=21, email=root@qq.com, username=root}, 3={password=123456, gender=男, id=3, age=21, email=admin@qq.com, username=admin}}
        System.out.println("结果：" + userMap);

        sqlSession.close();
    }
}
