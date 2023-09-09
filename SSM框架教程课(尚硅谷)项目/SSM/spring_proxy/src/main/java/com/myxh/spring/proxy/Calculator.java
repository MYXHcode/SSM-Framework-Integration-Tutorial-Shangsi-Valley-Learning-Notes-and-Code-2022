package com.myxh.spring.proxy;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public interface Calculator
{
    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    Integer add(Integer x, Integer y);

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    Integer sub(Integer x, Integer y);

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    Integer mul(Integer x, Integer y);

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    Integer div(Integer x, Integer y);
}
