package com.myxh.springmvc.config;

import jakarta.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description 代替 web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer
{
    /**
     * 设置一个配置类代替 Spring 的配置文件
     *
     * @return 根应用程序上下文的配置，如果不需要创建和注册根上下文，则为 null
     */
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 设置一个配置类代替 SpringMVC 的配置文件
     * @return Servlet 应用程序上下文的配置，如果所有配置都是通过根配置类指定的，则为 null
     */
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]{WebConfig.class};
    }

    /**
     * 设置 SpringMVC 的前端控制器 DispatcherServlet 的 url-pattern
     */
    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }

    /**
     * 设置当前的过滤器
     * @return 筛选器数组或 null
     */
    @Override
    protected Filter[] getServletFilters()
    {
        // 创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        // 创建处理请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}