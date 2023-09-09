package com.myxh.spring.service.impl;

import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    // @Qualifier("userDaoImpl")
    private UserDao userDao;

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
