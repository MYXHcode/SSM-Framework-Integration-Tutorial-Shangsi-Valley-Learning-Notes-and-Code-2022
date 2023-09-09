package com.myxh.spring.test;

import com.myxh.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class IocByXmlTest
{
    /**
     * 获取 bean 的三种方式：
     * 1、根据 bean 的 id 获取
     * 2，根据 bean 的类型获取
     * 注意：根据类型获 bean 时，要求 IOC 容器中有且只有一个类型匹配的 bean
     * 若没有任何一个类型匹配的 bean，此时抛出异常：NoSuchBeanDefinitionException
     * 若有多个类型匹配的 bean，此时抛出异常：NoUniqueBeanDefinitionException
     * 3、根据 bean 的 id 和类型获取
     *
     * 结论:
     * 根据类型来获取 bean 时，在满足 bean 唯一性的前提下
     * 其实只是看：对象 instanceof 指定的类型的返回结果
     * 只要返回的是 true 就可以认定为和类型匹配，能够获取到
     * 即通过 bean 的类型、bean 所继承的类的类型、bean 所实现的接口的类型都可以获取 bean
     */
    @Test
    public void testIOC()
    {
        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        // 获取 IOC 容器中的 bean
        // Student student1 = (Student) ioc.getBean("student1");
        // System.out.println("student1 = " + student1);

        // Student student = ioc.getBean(Student.class);
        // System.out.println("student = " + student);

        Student student1 = ioc.getBean("student1", Student.class);
        System.out.println("student1 = " + student1);

        // Person person = ioc.getBean(Person.class);
        // System.out.println("person = " + person);
    }

    @Test
    public void testDI()
    {
        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        // 获取 IOC 容器中的 bean
        // Student student2 = ioc.getBean("student2", Student.class);
        // System.out.println("student2 = " + student2);

        // Student student3 = ioc.getBean("student3", Student.class);
        // System.out.println("student3 = " + student3);

        // Student student4 = ioc.getBean("student4", Student.class);
        // System.out.println("student4.getGender().toString() = " + student4.getGender().toString());
        // System.out.println("student4 = " + student4);

        // Student student5 = ioc.getBean("student5", Student.class);
        // System.out.println("student5 = " + student5);

        Student student6 = ioc.getBean("student6", Student.class);
        System.out.println("student6 = " + student6);

        // Object clazzInner = ioc.getBean("clazzInner", Clazz.class);
        // System.out.println("clazzInner = " + clazzInner);

        // Clazz clazz1 = ioc.getBean("clazz1", Clazz.class);
        // System.out.println("clazz1 = " + clazz1);
    }
}
