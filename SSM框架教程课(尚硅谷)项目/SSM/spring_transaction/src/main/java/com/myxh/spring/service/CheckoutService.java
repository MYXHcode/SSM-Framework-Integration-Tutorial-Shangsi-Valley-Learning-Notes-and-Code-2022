package com.myxh.spring.service;

/**
 * @author MYXH
 * @date 2023/8/29
 */
public interface CheckoutService
{
    /**
     * 结账
     *
     * @param userId 用户 id
     * @param bookIds 一些图书 id
     */
    void checkout(Integer userId, Integer[] bookIds);
}
