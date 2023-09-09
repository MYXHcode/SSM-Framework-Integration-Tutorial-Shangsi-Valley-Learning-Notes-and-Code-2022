package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/1
 */
@Controller
public class TestViewController
{
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView()
    {
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResonanceView()
    {
        return "forward:/test/model";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView()
    {
        return "redirect:/test/model";
    }
}
