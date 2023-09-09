package com.myxh.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 * <p>
 * 2、使用 ModelAndView 向 request 域对象共享数据
 * 使刚 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要 ModelAndView 作为方法的返回值
 * <p>
 * 3、使用 Model 向 request 域对象共享数据
 * <p>
 * 4、使用 ModelMap 向 request 域对象共享数据
 * <p>
 * 5、使用 map 向 request 域对象共享数据
 * <p>
 * 6、Model 和 ModelMap 和 map 的关系
 * 其实在底层中，这些类型的形参最终都是通过 BindingAwareModelMap 创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 * public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {}
 * public interface Model {}
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    /**
     * ModelAndView 包含 Model 和 view 的功能
     * Model：向请求域中共享数据
     * view：设置逻辑视图实现页面跳转
     *
     * @return 模型和视图
     */
    @RequestMapping("/test/model/and/view")
    public ModelAndView testModelAndView()
    {
        ModelAndView modelAndView = new ModelAndView();

        // 向请求域中共享数据
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        // 设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("model.getClass().getName() = " + model.getClass().getName());

        // 向请求域中共享数据
        model.addAttribute("testRequestScope", "Hello, Model");
        Object testRequestScope = model.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/model/map")
    public String testModelMap(ModelMap modelMap)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("modelMap.getClass().getName() = " + modelMap.getClass().getName());

        // 向请求域中共享数据
        modelMap.addAttribute("testRequestScope", "Hello, ModelMap");
        Object testRequestScope = modelMap.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("map.getClass().getName() = " + map.getClass().getName());

        // 向请求域中共享数据
        map.put("testRequestScope", "Hello, map");
        Object testRequestScope = map.get("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session)
    {
        session.setAttribute("testSessionScope", "Hello, Session");
        Object testSessionScope = session.getAttribute("testSessionScope");
        System.out.println("testSessionScope = " + testSessionScope);

        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session)
    {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "Hello, Application");
        Object testApplicationScope = servletContext.getAttribute("testApplicationScope");
        System.out.println("testApplicationScope = " + testApplicationScope);

        return "success";
    }
}
