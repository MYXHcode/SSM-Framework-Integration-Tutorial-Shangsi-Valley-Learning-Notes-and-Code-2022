package com.myxh.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/8/28
 */
@Component
public class CalculatorImpl implements Calculator
{
    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    @Override
    public Integer add(Integer x, Integer y)
    {
        Integer result = x + y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    @Override
    public Integer sub(Integer x, Integer y)
    {
        Integer result = x - y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    @Override
    public Integer mul(Integer x, Integer y)
    {
        Integer result = x * y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    @Override
    public Integer div(Integer x, Integer y)
    {
        Integer result = x / y;
        System.out.println("方法内部：result = " + result);

        return result;
    }
}
