package com.myxh.spring.controller;

import com.myxh.spring.service.BookService;
import com.myxh.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Controller
public class BookController
{
    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer userId, Integer bookId)
    {
        bookService.buyBook(userId, bookId);
    }

    public void checkout(Integer userId, Integer[] bookIds)
    {
        checkoutService.checkout(userId, bookIds);
    }
}
