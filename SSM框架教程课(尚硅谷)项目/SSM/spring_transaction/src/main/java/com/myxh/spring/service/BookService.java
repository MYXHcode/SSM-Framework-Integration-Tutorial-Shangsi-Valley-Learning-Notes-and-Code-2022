package com.myxh.spring.service;

/**
 * @author MYXH
 * @date 2023/8/29
 */
public interface BookService
{
    /**
     * 买书
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     */
    void buyBook(Integer userId, Integer bookId);
}
