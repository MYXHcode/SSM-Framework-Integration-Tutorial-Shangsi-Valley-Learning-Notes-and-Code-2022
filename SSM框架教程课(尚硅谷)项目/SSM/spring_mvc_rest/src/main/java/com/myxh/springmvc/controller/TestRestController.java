package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description
 * 查询所有的用户信息：/user -> GET
 * 根据 id 查询用户信息：/user/1 -> GET
 * 添加用户信息：/user -> POST
 * 修改用户信息：/user -> PUT
 * 根据 id 删除用户信息：/user/1 -> DELETE
 * <p>
 * 注意：浏览器目前只能发送 get 和 post 请求
 * 若要发送 put 和 delete 请求，需要在 web.xml 中配置一个过滤器 HiddenHttpMethodFilter
 * 配置了过滤器之后，发送的请求要满足两个件，才能将请求方式转换为 put 或 delete
 * 1、当前请求必须为 post
 * 2、当前请求必须传输请求参数 method，method 的值才是最终的请求方式
 */
@Controller
public class TestRestController
{
    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser()
    {
        System.out.println("查询所有的用户信息：/user -> GET");

        return "success";
    }

    // @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id)
    {
        System.out.println("根据 id 查询用户信息：/user/" + id + "-> GET");

        return "success";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String insertUser()
    {
        System.out.println("添加用户信息：/user -> POST");

        return "success";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser()
    {
        System.out.println("修改用户信息：/user -> PUT");

        return "success";
    }

    // @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id)
    {
        System.out.println("根据 id 删除用户信息：/user/" + id + "-> DELETE");

        return "success";
    }
}
