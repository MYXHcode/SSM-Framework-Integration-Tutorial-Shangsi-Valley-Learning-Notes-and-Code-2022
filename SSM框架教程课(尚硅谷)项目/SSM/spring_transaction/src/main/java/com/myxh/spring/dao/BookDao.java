package com.myxh.spring.dao;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
public interface BookDao
{
    /**
     * 根据图书的 id 查询图书的价格
     *
     * @param bookId 图书 id
     * @return 图书价格
     */
    BigDecimal getPriceByBookId(Integer bookId);

    /**
     * 更新图书的库存
     *
     * @param bookId 图书 id
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户的余额
     *
     * @param userId 用户 id
     * @param price  图书价格
     */
    void updateBalance(Integer userId, BigDecimal price);
}
