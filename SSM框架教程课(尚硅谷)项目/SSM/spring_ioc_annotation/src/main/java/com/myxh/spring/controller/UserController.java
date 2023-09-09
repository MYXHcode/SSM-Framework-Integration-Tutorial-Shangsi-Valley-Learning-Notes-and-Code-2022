package com.myxh.spring.controller;

import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/24
 */
// @Controller("userController")
@Controller
public class UserController
{
    // @Autowired(required = false)
    // @Qualifier("userServiceImpl")
    @Autowired
    private  UserService userService;

    public UserController()
    {

    }

    /*
    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
     */

    /*
    public UserService getUserService()
    {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
     */

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
