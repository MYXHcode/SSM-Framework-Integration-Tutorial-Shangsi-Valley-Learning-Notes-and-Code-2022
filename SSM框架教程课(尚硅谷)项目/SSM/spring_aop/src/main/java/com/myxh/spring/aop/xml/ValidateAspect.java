package com.myxh.spring.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/8/28
 */
@Component
public class ValidateAspect
{
    public void beforeMethod()
    {
        System.out.println("ValidateAspect -> 前置通知");
    }
}
