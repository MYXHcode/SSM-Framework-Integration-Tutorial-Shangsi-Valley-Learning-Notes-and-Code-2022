package com.myxh.spring.controller;

import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class UserController
{
    private UserService userService;

    public UserService getUserService()
    {
        return userService;
    }

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    public void saveUser(User user)
    {
        userService.saveUser(user);
    }
}
