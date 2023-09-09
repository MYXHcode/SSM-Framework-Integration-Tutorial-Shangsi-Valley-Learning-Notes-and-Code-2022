package com.myxh.spring.service;

import com.myxh.spring.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public interface UserService
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    void saveUser(User user);
}
