package com.myxh.spring.proxy;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public class CalculatorStaticProxy implements Calculator
{
    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target)
    {
        this.target = target;
    }

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
        System.out.println("[日志] 方法：add，参数：[" + x + ", " + y + "]");

        Integer result = target.add(x, y);

        System.out.println("[日志] 方法：add，结果：" + result);

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
        System.out.println("[日志] 方法：sub，参数：[" + x + ", " + y + "]");

        Integer result = target.sub(x, y);

        System.out.println("[日志] 方法：sub，结果：" + result);

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
        System.out.println("[日志] 方法：mul，参数：[" + x + ", " + y + "]");

        Integer result = target.mul(x, y);

        System.out.println("[日志] 方法：mul，结果：" + result);

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
        System.out.println("[日志] 方法：div，参数：[" + x + ", " + y + "]");

        Integer result = target.div(x, y);

        System.out.println("[日志] 方法：div，结果：" + result);

        return result;
    }
}
