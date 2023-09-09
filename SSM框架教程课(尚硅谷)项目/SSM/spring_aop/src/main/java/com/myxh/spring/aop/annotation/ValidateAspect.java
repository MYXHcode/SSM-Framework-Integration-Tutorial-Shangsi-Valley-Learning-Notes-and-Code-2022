package com.myxh.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/8/28
 */
@Component
@Aspect
@Order(1)
public class ValidateAspect
{
    // @Before("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.myxh.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod()
    {
        System.out.println("ValidateAspect -> 前置通知");
    }
}
