package com.myxh.springmvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 拦截器的三个方法：
 * preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截（false）或放行（true）
 * postHandle()：在控制器方法执行之后执行
 * afterCompletion()：在控制器方法执行之后，且渲染视图完毕之后执行
 * <p>
 * 多个拦截器的执行顺序和在 SpringMVC 的配置文件中配置的顺序有关
 * preHandle() 按照配置的顺序执行，而 postHandle()和 afterCompletion() 按照配置的反序执行
 * <p>
 * 若拦截器中有某个拦截器的 preHandle() 返回了 false
 * 拦截器的 preHandle() 返回 false 和它之前的拦截器的 preHandle() 都会执行
 * 所有的拦截器的 postHandle() 都不执行
 * 拦截器的 preHandle() 返回 false 之前的拦截器的 afterCompletion() 会执行
 */
@Component
public class SecondInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        System.out.println("SecondInterceptor -> preHandle");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    {
        System.out.println("SecondInterceptor -> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        System.out.println("SecondInterceptor -> afterCompletion");
    }
}
