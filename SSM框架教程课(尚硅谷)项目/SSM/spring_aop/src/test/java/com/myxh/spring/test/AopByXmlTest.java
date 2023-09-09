package com.myxh.spring.test;

import com.myxh.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/28
 */
public class AopByXmlTest
{
    @Test
    public void testAopByXml()
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1, 2);
        calculator.sub(2, 1);
        // calculator.div(1, 0);
        calculator.div(10, 2);
    }
}
