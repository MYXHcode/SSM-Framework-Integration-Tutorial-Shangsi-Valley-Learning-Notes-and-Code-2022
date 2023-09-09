package com.myxh.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author MYXH
 * @date 2023/8/15
 */
public class SqlSessionUtil
{
    public static SqlSession getSqlSession()
    {
        SqlSession sqlSession = null;

        try
        {
            // 获取核心配置文件的输入流
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取 sqlSessionFactoryBuilder 对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            // 获取 sqlSessionFactory 对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

            // 获取 sqlSession 对象
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return sqlSession;
    }
}
