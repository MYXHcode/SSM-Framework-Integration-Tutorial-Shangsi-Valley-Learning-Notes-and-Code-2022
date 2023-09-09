package com.myxh.spring.test;

import com.myxh.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MYXH
 * @date 2023/8/29
 * @description
 * 声明式事务的配置步骤：
 * 1、在 Spring 的配置文件中配置事务管理器
 * 2、开启事务的注解驱动
 * <p>
 * 在需要被事务管理的方法上，添加 @Transactional 注解，该方法就会被事务管理
 * {@code @Transactional}注解标识的位置：
 * 1、标识在方法上
 * 2、标识在类上，则类中所有的方法都会被事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest
{
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook()
    {
        // bookController.buyBook(1,1);

        bookController.checkout(1,new Integer[]{1, 2});
    }
}
