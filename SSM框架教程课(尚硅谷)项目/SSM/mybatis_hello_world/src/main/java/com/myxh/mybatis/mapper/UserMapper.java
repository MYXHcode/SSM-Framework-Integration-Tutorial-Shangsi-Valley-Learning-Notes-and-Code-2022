package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.User;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/11
 */
public interface UserMapper
{
    /**
     * 添加用户信息
     *
     * @return 影响的行数
     */
    int insertUser();

    /**
     * 修改用户信息
     *
     * @return 影响的行数
     */
    int updateUser();

    /**
     * 删除用户信息
     *
     * @return 影响的行数
     */
    int deleteUser();

    /**
     * 根据 id 查询用户信息
     *
     * @param id 用户 id
     * @return 一个用户信息
     */
    User getUserById(Integer id);

    /**
     * 查询所有的用户信息
     *
     * @return 所有用户信息
     */
    List<User> getAllUser();
}