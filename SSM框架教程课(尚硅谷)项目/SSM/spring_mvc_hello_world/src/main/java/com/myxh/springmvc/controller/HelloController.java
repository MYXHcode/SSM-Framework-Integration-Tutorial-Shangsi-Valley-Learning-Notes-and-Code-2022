package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/8/31
 */
@Controller
public class HelloController
{
    @RequestMapping("/")
    public String portal()
    {
        // 将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello()
    {
        return "success";
    }
}
