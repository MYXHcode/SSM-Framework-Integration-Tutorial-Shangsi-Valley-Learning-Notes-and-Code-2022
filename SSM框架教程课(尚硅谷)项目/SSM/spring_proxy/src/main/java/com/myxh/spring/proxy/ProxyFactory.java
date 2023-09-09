package com.myxh.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public class ProxyFactory
{
    private final Object target;

    public ProxyFactory(Object target)
    {
        this.target = target;
    }

    public Object getProxy()
    {
        /*
          ClassLoader loader：指定加载动态生成的代理类的类加载器
          Class<?>[] interfaces：获取目标对象实现的所有接口的 class 对象的数组
          InvocationHandler h：设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler()
        {
            /**
             * proxy 表示代理对象，method 表示要执行的方法，args 表示要执行的方法的参数列表
             *
             * @param proxy 调用该方法的代理实例
             *
             * @param method 与代理实例上调用的接口方法相对应的 method 实例。
             *               Method 对象的声明类将是在其中声明该方法的接口，该接口可能是代理类通过其继承该方法的代理接口的超接口。
             *
             * @param args 一个对象数组，包含在代理实例上的方法调用中传递的参数值，如果接口方法不接受参数，则为 null。
             *             基元类型的参数被包装在适当的基元包装类的实例中，例如 java.lang.Integer 或 java.lang.Boolean。
             *
             * @return 从代理实例上的方法调用返回的值。
             * 如果接口方法声明的返回类型是基元类型，则此方法返回的值必须是相应基元包装类的实例；否则，它必须是可分配给声明的返回类型的类型。
             * 如果此方法返回的值为 null，并且接口方法的返回类型为基元，则方法调用将在代理实例上引发 NullPointerException。
             * 如果此方法返回的值与如上所述接口方法声明的返回类型不兼容，则方法调用将在代理实例上引发 ClassCastException
             * @throws Throwable 从代理实例上的方法调用中抛出的异常。
             * 异常的类型必须可分配给接口方法的 throws 子句中声明的任何异常类型，或者可分配给未检查的异常类型 java.lang.RuntimeException或java.lang.Error。
             * 如果此方法抛出了一个检查的异常，但该异常不可分配给接口方法的 throw 子句中声明任何异常类型，则包含此方法引发的异常的 UndeclaredThrowableException 将由代理实例上的方法调用引发。
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
            {
                Object result = null;

                try
                {
                    System.out.println("[日志] 方法：" + method.getName() + "，参数：" + Arrays.toString(args));

                    result = method.invoke(target, args);

                    System.out.println("[日志] 方法：" + method.getName() + "，结果：" + result);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    System.out.println("[日志] 方法：" + method.getName() + "，异常：" + e);
                    e.printStackTrace();
                } finally
                {
                    System.out.println("[日志] 方法：" + method.getName() + "，方法执行完毕");
                }

                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
