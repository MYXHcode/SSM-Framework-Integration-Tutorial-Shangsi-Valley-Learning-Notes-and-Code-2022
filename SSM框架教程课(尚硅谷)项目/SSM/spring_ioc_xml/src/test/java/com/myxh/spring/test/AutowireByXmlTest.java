package com.myxh.spring.test;

import com.myxh.spring.controller.UserController;
import com.myxh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class AutowireByXmlTest
{
    /**
     * 自动装配：
     * 根据指定的策略，在 IOC 容器中匹配某个 bean，自动为 bean 中的类类型的属性或接口类型的属性赋值
     * 可以通过 bean 标签中的 autowire 属性设置自动装配的策略
     * <p>
     * 自动装配的策略：
     * 1、no、default：表示不装配，即 bean 中的属性不会自动匹配某个 bean 为属性赋值，此时属性使用默认值
     * 2、byType：根据要赋值的属性的类型，在 IOC 容器中匹配某个 bean，为属性赋值
     * 注意：
     * ① 若通过类型没有找到任何一个类型匹配的 bean，此时不装配，属性使用默认值
     * ② 若通过类型找到了多个类型匹配的 bean，此时会抛出异常：NoUniqueBeanDefinitionException
     * 总结：当使用 byType 实现自动装配时，IOC 容器中有且只有一个类型匹配的 bean 能够为属性赋值
     * 3、byName：将要赋值的属性的属性名作为 bean 的 id 在 IOC 容器中匹配 bean，为属性赋值
     * 总结：当类型匹配 bean 有多个时，此时可以使用 byName 实现自动装配
     */
    @Test
    public void testAutowire()
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        User user = ioc.getBean(User.class);
        System.out.println("user = " + user);
        UserController userController = ioc.getBean(UserController.class);
        System.out.println("userController = " + userController);
        userController.saveUser(user);
    }
}
