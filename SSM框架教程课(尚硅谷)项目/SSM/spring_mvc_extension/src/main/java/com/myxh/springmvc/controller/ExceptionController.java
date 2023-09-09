package com.myxh.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author MYXH
 * @date 2023/9/6
 */
// 将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController
{
    // 设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model)
    {
        // ex 表示控制器方法所出现的异常
        model.addAttribute("ex", ex);

        return "error";
    }
}
