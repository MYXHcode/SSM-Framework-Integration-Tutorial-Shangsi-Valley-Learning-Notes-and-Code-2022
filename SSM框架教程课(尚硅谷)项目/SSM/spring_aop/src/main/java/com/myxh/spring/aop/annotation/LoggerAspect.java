package com.myxh.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author MYXH
 * @date 2023/8/28
 * @description
 * 1、在切面中，需要通过指定的注解将方法标识为通知方法
 * {@code @Before}：前置通知，在目标对象方法执行之前执行
 * {@code @After}：后置通知，在目标对象方法的 finally 字句中执行
 * {@code @AfterReturning}：返回通知，在目标对象方法返回值之后执行
 * {@code @AfterThrowing}：异常通知，在目标对象方法的 catch 子句中执行
 * {@code @Around}：环绕通知，环绕通知的方法的返回值一定要和目标对象方法的返回值一致
 * <p>
 * 2、切入点表达式：设置在标识通知的注解的 value 属性中
 * {@code execution(public Integer com.myxh.spring.aop.annotation.CalculatorImpl.add(Integer, Integer))}
 * {@code execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))}
 * 第一个 * 表示任意的访问修饰符和返回值类型
 * 第二个 * 表示类中任意的方法
 * .. 表示任意的参数列表
 * 类的地方也可以使用 *，表示包下所有的类
 * <p>
 * 3、重用切入点表达式
 * {@code @Pointcut} 声明一个公共的切入点表达式
 * {@code @Pointcut("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
 * public void pointCut()
 * {
 * <p>
 * }}
 * 使用方式：
 * {@code @Before("pointCut()")}
 * <p>
 * 4、获取连接点的信息
 * 在通知方法的参数位置，设置 JoinPoint 类型的参数，就可以获取连接点所对应方法的信息
 * {@code
 * // 获取连接点所对应方法的签名信息
 * Signature signature = joinPoint.getSignature();
 * <p>
 * // 获取连接点所对应方法的方法名
 * String name = signature.getName();
 * <p>
 * // 获取连接点所对应方法的参数
 * Object[] args = joinPoint.getArgs();
 * }
 * <p>
 * 5、切面的优先级
 * 可以通过 {@code @order} 注解的 value 属性设置优先级，默认值为 Integer 的最大值
 * {@code @order} 注解的 value 属性值越小，优先级越高
 */
@Component
// 将当前组件标识为切面
@Aspect
public class LoggerAspect
{
    // @Pointcut 声明一个公共的切入点表达式
    @Pointcut("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut()
    {

    }

    // @Before("execution(public Integer com.myxh.spring.aop.annotation.CalculatorImpl.add(Integer, Integer))")
    // @Before("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
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

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，方法执行完毕");
    }

    /**
     * 在返回通知中若要获取目标对象方法的返回值
     * 只需要通过 {@code @AfterReturning} 注解的 returning 属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
     *
     * @param joinPoint 连接点
     * @param result 结果
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，结果：" + result);
    }

    /**
     * 在异常通知中若要获取目标对象方法的异常
     * 只需要通过 {@code @AfterThrowing} 注解的 throwing 属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法出现的异常的参数
     *
     * @param joinPoint 连接点
     * @param exception 异常
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
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
    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint)
    {
        Object result = null;

        try
        {
            System.out.println("环绕通知 -> 前置通知");

            // 表示目标对象方法的执行
            result  = joinPoint.proceed();

            System.out.println("环绕通知 -> 返回通知");
        }
        catch (Throwable e)
        {
            System.out.println("环绕通知 -> 异常通知");
            e.printStackTrace();
        }
        finally
        {
            System.out.println("环绕通知 -> 后置通知");
        }

        return result;
    }
}
