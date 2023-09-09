package com.myxh.spring.dao.impl;

import com.myxh.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Repository
public class BookDaoImpl implements BookDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据图书的 id 查询图书的价格
     *
     * @param bookId 图书 id
     * @return 图书价格
     */
    @Override
    public BigDecimal getPriceByBookId(Integer bookId)
    {
        String sql = "select price from t_book where book_id = ?;";
        BigDecimal price = jdbcTemplate.queryForObject(sql, BigDecimal.class, bookId);

        return price;
    }

    /**
     * 更新图书的库存
     *
     * @param bookId 图书 id
     */
    @Override
    public void updateStock(Integer bookId)
    {
        String sql = "update t_book set stock = stock - 1 where book_id = ?;";
        jdbcTemplate.update(sql,bookId);
    }

    /**
     * 更新用户的余额
     *
     * @param userId 用户 id
     * @param price  图书价格
     */
    @Override
    public void updateBalance(Integer userId, BigDecimal price)
    {
        String sql = "update t_bookstore_user set balance = balance - ? where user_id = ?;";
        jdbcTemplate.update(sql,price, userId);
    }
}
