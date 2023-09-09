package com.myxh.springmvc.controller;

import com.myxh.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用 @RequestBody 注解将 json 格式的请求参数转换为 Java 对象
 * ① 导入 jackson 的依赖
 * ② 在 SpringMVC 的配置文件中设置 <mvc:annotation-driven/>
 * ③ 在处理请求的控制器方法的形参位置，直接设置 json 格式的请求参数要转换的 Java 类型的形参，使用 @RequestBody 注解标识即可
 * 3、@ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 * 4、使用 @ResponseBody 注解响应浏览器 json 格式的数据
 * ① 导入 jackson 的依赖
 * ② 在 SpringMVC 的配置文件中设置 <mvc:annotation-driven/>
 * ③ 将需要转换为 json 字符串的 Java 对象直接作为控制器方法的返回值，使用 @ResponseBody 注解标识控制器方法
 * 就可以将 Java 对象直接转换为 json 字符串，并响应到浏览器
 * <p>
 * 常用的 Java 对象转换为 json 的结果：
 * 实体类 -> json 对象
 * Map -> json 对象
 * List -> json 数组
 */
@Controller
// @RestController 相当于 @Controller + @ResponseBody
// @RestController
public class TestAjaxController
{
    @RequestMapping("/test/ajax")
    public void testAjax(@RequestBody String requestBody, HttpServletResponse response, Integer id) throws IOException
    {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("Hello, axios");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException
    {
        System.out.println("user = " + user);
        response.getWriter().write("Hello, requestBody");
    }

    // @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException
    {
        System.out.println("map = " + map);
        response.getWriter().write("Hello, requestBody");
    }

    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody()
    {
        return "Hello, responseBody";
    }

    @RequestMapping("/test/responseBody/json")
    @ResponseBody
    public User testResponseBodyJson()
    {
        User user = new User(1, "MYXH", "520.ILY!", 21, "男", "1735350920@qq.com");

        return user;
    }

    /*
    @RequestMapping("/test/responseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson()
    {
        User user1 = new User(1, "MYXH", "520.ILY!", 21, "男", "1735350920@qq.com");
        User user2 = new User(2, "root", "000000", 21, "男", "root@qq.com");
        User user3 = new User(3, "admin", "123456", 21, "男", "admin@qq.com");
        User user4 = new User(4, "test", "test", 18, "男", "test@qq.com");
        List<User> list = Arrays.asList(user1, user2, user3, user4);

        return list;
    }
     */

    /*
    @RequestMapping("/test/responseBody/json")
    @ResponseBody
    public Map<String , Object> testResponseBodyJson()
    {
        User user1 = new User(1, "MYXH", "520.ILY!", 21, "男", "1735350920@qq.com");
        User user2 = new User(2, "root", "000000", 21, "男", "root@qq.com");
        User user3 = new User(3, "admin", "123456", 21, "男", "admin@qq.com");
        User user4 = new User(4, "test", "test", 18, "男", "test@qq.com");
        Map<String, Object> map = new HashMap<>();
        map.put("1", user1);
        map.put("2", user2);
        map.put("3", user3);
        map.put("4", user4);

        return map;
    }
     */
}
