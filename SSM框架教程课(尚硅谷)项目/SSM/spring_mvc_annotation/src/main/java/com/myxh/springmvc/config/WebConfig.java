package com.myxh.springmvc.config;

import com.myxh.springmvc.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description 代替 SpringMVC 的配置文件
 * 扫描组件、视图解析器、默认的 servlet、mvc 的注解驱动
 * 视图控制器、文件上传解析器、拦截器、异常解析器
 */
// 将类标识为配置类
@Configuration
// 扫描组件
@ComponentScan("com.myxh.springmvc.controller")
// 开启 mvc 的注解驱动
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{
    /**
     * 默认的 servlet 处理静态资源
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    /**
     * 配置视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * {@code @Bean} 注解可以将标识的方法的返回值作为 bean 进行管理，bean 的 id 为方法的方法名
     */
    @Bean
    public StandardServletMultipartResolver multipartResolver()
    {
        return new StandardServletMultipartResolver();
    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        FirstInterceptor firstInterceptor = new FirstInterceptor();
        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
    }

    /**
     * 配置异常解析器
     *
     * @param resolvers 解析器–最初是一个空列表
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers)
    {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        exceptionResolver.setExceptionMappings(prop);
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    /**
     * 配置生成模板解析器
     *
     * @return templateResolver 模板解析程序
     */
    @Bean
    public ITemplateResolver templateResolver()
    {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        return templateResolver;
    }

    /**
     * 生成模板引擎并为模板引擎注入模板解析器
     *
     * @param templateResolver 模板解析程序
     * @return templateEngine 模板引擎
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver)
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        return templateEngine;
    }

    /**
     * 生成视图解析器并未解析器注入模板引擎
     *
     * @param templateEngine 模板引擎
     * @return viewResolver 视图解析程序
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine)
    {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);

        return viewResolver;
    }
}
