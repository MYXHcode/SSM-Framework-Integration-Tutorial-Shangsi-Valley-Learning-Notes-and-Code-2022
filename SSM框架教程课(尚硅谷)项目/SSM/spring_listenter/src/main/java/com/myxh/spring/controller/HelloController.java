package com.myxh.spring.controller;

import com.myxh.spring.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/9/9
 */
@Controller
public class HelloController
{
    @Autowired
    private HelloService helloService;
}
