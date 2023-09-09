package com.myxh.spring.service.impl;

import com.myxh.spring.service.BookService;
import com.myxh.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Service
public class CheckoutServiceImpl implements CheckoutService
{
    @Autowired
    private BookService bookService;

    /**
     * 结账
     *
     * @param userId 用户 id
     * @param bookIds 一些图书 id
     */
    @Override
    // @Transactional
    public void checkout(Integer userId, Integer[] bookIds)
    {
        for (Integer bookId : bookIds)
        {
            bookService.buyBook(userId,bookId);
        }
    }
}
