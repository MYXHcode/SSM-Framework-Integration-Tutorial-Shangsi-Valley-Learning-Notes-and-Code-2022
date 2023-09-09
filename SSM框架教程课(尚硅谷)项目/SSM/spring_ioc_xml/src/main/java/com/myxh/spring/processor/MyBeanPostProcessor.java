package com.myxh.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class MyBeanPostProcessor implements BeanPostProcessor
{
    /**
     * 此方法在 bean 的生命周期初始化之前执行
     *
     * @param bean     新的 bean 实例
     * @param beanName bean 的名称
     * @return 要使用的bean实例，原始实例或已包装实例；
     * 如果为 null，则不会调用后续 BeanPostProcessors
     * @throws org.springframework.beans.BeansException 如果出现错误
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("MyBeanPostProcessor -> 后置处理器 postProcessBeforeInitialization");

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 此方法在 bean 的生命周期初始化之后执行
     *
     * @param bean     新的 bean 实例
     * @param beanName bean 的名称
     * @return 要使用的 bean 实例，原始实例或已包装实例；
     * 如果为 null，则不会调用后续 BeanPostProcessors
     * @throws org.springframework.beans.BeansException 如果出现错误
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("MyBeanPostProcessor -> 后置处理器 postProcessAfterInitialization");

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
