package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/6
 */
@Controller
public class TestController
{
    @RequestMapping("/test/hello")
    public String testHello()
    {
        return "success";
    }

    @RequestMapping("/test/exception")
    public String testException()
    {
        System.out.println("1 / 0 = " + 1 / 0);

        return "success";
    }
}
