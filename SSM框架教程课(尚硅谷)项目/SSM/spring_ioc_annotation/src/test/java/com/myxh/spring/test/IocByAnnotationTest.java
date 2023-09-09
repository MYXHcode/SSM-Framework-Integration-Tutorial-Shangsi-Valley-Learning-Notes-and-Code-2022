package com.myxh.spring.test;

import com.myxh.spring.controller.UserController;
import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class IocByAnnotationTest
{
    /**
     * {@code @Component}：将类标识为普通组件
     * {@code @Controller}：将类标识为控制层组件
     * {@code @Service}：将类标识为业务层组件
     * {@code @Repository}：将类标识为持久层组件
     * <p>
     * 通过注解 + 扫描所配置的 bean 的 id，默认值为类的小驼峰，即类名的首宇母为小写的结果
     * 可以通过标识组件的注解的 value 属性值设置 bean 的自定义的 id
     * <p>
     * {@code @Autowired}：实现自动装配功能的注解
     * 1、{@code @Autowired} 注解能够标识的位置
     * ① 标识在成员变量上，此时不需要设置成员变量的 set 方法
     * ② 标识在 set 方法上
     * ③ 标识在为当前成员变量赋值的有参构造上
     * <p>
     * 2、{@code @Autowired} 注解的原理
     * ① 默认通过 byType 的方式，在 IOC 容器中通过类型匹配某个 bean 为属性赋值
     * ② 有多个类型匹配的 bean，此时会自动转换为 byName 的方式实现自动装配的效果
     * 即把要赋值的属性的属性名作为 bean 的 id 匹配某个 bean 为属性赋值
     * ③ 若 byType 和 byName 的方式都无法实现自动装配，即 IOC 容器中有多个类型匹配的 bean
     * 且这些 bean 的 id 和要赋值的属性的属性名都不一致，此时抛异常：NoUniqueBeanDefinitionException
     * ④ 此时可以在要赋值的属性上，添加一个注解 @Qualifier
     * 通过该注解的 value 属性值，指定某个 bean 的 id，将这个 bean 为属性赋值
     * <p>
     * 注意：IOC 容器中没有任何一个类型匹配的 bean，此时抛出异常：NoSuchBeanDefinitionException
     * 在 {@code @Autowired} 注解中有个属性 required，默认值为 true，要求必须完成自动装配
     * 可以将 required 设置为 false，此时能装配则装配，无法装配则使用属性的默认值
     */
    @Test
    public void testIoc()
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        User user = ioc.getBean("user", User.class);
        System.out.println("user = " + user);
        UserController userController = ioc.getBean("userController", UserController.class);
        System.out.println("userController = " + userController);
        // UserService userService = ioc.getBean("userServiceImpl", UserService.class);
        // System.out.println("userService = " + userService);
        UserDao userDao = ioc.getBean("userDaoImpl", UserDao.class);
        System.out.println("userDao = " + userDao);
        userController.saveUser(user);
    }
}
