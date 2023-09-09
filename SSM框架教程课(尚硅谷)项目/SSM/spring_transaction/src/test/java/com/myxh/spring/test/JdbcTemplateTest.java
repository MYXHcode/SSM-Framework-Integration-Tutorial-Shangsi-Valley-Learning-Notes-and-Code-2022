package com.myxh.spring.test;

import com.myxh.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/29
 */
// 指定当前测试类在 Spring 的测试环境中执行，此时就可以通过注入的方式直接获取 IOC 容器中的 bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置 spring 测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert()
    {
        String sql = "insert into t_user (id, username, password, age, gender, email) values (null, ?, ?, ?, ?, ?);";
        int result = jdbcTemplate.update(sql, "test", "test", 18, "男", "test@@qq.com");
        System.out.println("result = " + result);
    }
    
    @Test
    public void testGetUserById()
    {
        String sql = "select * from t_user where id = ?;";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println("user = " + user);
    }

    @Test
    public void testGetAllUser()
    {
        String sql = "select * from t_user;";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        userList.forEach(System.out::println);
    }
    
    @Test
    public void testGetCount()
    {
        String sql = "select count(*) from t_user;";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count = " + count);
    }
}
