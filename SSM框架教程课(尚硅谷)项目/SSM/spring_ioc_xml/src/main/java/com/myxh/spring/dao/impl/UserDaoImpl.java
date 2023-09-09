package com.myxh.spring.dao.impl;

import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class UserDaoImpl implements UserDao
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    @Override
    public void saveUser(User user)
    {
        System.out.println("保存用户信息成功");
    }
}
