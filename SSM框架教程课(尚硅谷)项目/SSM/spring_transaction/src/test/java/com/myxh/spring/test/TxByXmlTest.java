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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXmlTest
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
