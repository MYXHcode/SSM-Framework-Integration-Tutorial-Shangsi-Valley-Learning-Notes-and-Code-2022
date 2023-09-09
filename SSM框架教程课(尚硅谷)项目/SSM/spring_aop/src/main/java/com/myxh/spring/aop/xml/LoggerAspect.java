package com.myxh.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author MYXH
 * @date 2023/8/28
 */
@Component
public class LoggerAspect
{
    public void beforeAdviceMethod(JoinPoint joinPoint)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("[LoggerAspect] 方法：" + name + "，参数：" + Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，方法执行完毕");
    }


    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，结果：" + result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable exception)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，异常：" + exception);
    }

    /**
     * 环绕通知的方法的返回值一定要和目标对象方法的返回值一致
     *
     * @param joinPoint 连接点
     * @return result 结果
     */
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint)
    {
        Object result = null;

        try
        {
            System.out.println("环绕通知 -> 前置通知");

            // 表示目标对象方法的执行
            result = joinPoint.proceed();

            System.out.println("环绕通知 -> 返回通知");
        } catch (Throwable e)
        {
            System.out.println("环绕通知 -> 异常通知");
            e.printStackTrace();
        } finally
        {
            System.out.println("环绕通知 -> 后置通知");
        }

        return result;
    }
}
