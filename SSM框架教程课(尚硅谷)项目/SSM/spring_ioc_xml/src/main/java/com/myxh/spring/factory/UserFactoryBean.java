package com.myxh.spring.factory;

import com.myxh.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author MYXH
 * @date 2023/8/24
 * @description
 * FactoryBean 是一个接口，需要创建一个类实现该接口
 * 其中有三个方法：
 * getObject()：通过一个对象交给 IOC 容器管理
 * getObjectType()：设置所提供对象的类型
 * isSingleton()：所提供的对象是否单例
 * 当把 FactoryBean 的实现类配置为 bean 时，会将当前类中 getObject() 所返回的对象交给 IOC 容器管理
 */
public class UserFactoryBean implements FactoryBean
{
    @Override
    public Object getObject() throws Exception
    {
        return new User();
    }

    @Override
    public Class<?> getObjectType()
    {
        return User.class;
    }
}
