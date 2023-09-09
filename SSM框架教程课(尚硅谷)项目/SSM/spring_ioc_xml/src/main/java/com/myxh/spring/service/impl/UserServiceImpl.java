package com.myxh.spring.service.impl;

import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    public UserDao getUserDao()
    {
        return userDao;
    }

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    @Override
    public void saveUser(User user)
    {
        userDao.saveUser(user);
    }
}
