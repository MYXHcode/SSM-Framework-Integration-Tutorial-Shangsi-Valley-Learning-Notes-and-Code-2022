package com.myxh.spring.test;

import com.myxh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class LifeCycleTest
{
    /**
     * bean 的生命周期：
     * 1、实例化
     * 2、依赖注入
     * 3、后置处理器的 postProcessBeforeInitialization
     * 4、初始化，需要通过 bean 的 init-method 属性指定初始化的方法
     * 5、后置处理器的 postProcessAfterInitialization
     * 6、IOC 容器关闭时销毁，需要通过 bean 的 destroy-method 属性指定销毁的方法
     * <p>
     * bean 的后置处理器会在生命周期的初始化前后添加额外的操作
     * 需要实现 BeanPostprocessor 接口且配置到 IOC 容器中
     * 要注意的是，bean 后置处理器不是单独针对某一个 bean 生效，而是针对 IOC 容器中所有 bean 都会执行
     * <p>
     * 注意：
     * 若 bean 的作用域为单例时，生命周期的前三个步骤会在获取 IOC 器时执行
     * 若 bean 的作用域为多例时，生命周期的前三个步骤会在获取 bean 时执行
     */
    @Test
    public void testLifeCycle()
    {
        /*
          ConfigurableApplicationContext ApplicationContext 的子接口，其中扩展了刷新和关闭容器的方法
         */
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println("user = " + user);
        ioc.close();
    }
}
