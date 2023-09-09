package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 1、@RequestMapping 注解标识的位置
 * {@code @RequestMapping} 标识一个类：设置映射请求的请求路径的初始信息
 * {@code @RequestMapping} 标识一个方法：设置映射请求请求路径的具体信息
 * <p>
 * 2、@RequestMapping 注解 value 属性
 * 作用：通过请求的请求路径匹配请求
 * value 属性是数组类型，即当前浏览器所发送请求的请求路径匹配 value 属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * <p>
 * 3、@RequestMapping 注解的 method属性
 * 作用：通过请求的请求方式匹配请求
 * method 属性是 RequestMethod 类型的数组，即当前浏览器所发送请求的请求方式匹配 method 属性中的任何一中请求方式
 * 则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求方式不匹配
 * 此时页面报错：HTTP 状态 405 - Request method 'XXX' not supported
 * 在 @RequestMapping 的基础上，结合请求方式的一些派生注解：
 * {@code @GetMapping}, @PostMapping, @DeleteMapping, @PutMapping
 * <p>
 * 4、@RequestMapping 注解的 params 属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足 params 属性的设置
 * params 可以使用四种表达式：
 * "param"：表示当前所匹配请的请求参数中必须携带 param 参数
 * "!param"：表示当前所匹配请求的请求参数中一定不能携带 param 参数
 * "param=value"：表示当前所匹配请求的请求参数中必须携带 param 参数且值必须为 value
 * "param!=value"：表示当前所匹配请求的请求参数中可以不携带 param，若携带值一定不能是 value
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求参数不匹配
 * 此时页面报错：HTTP 状态 400 - Parameter conditions "username" not met for actual request parameters:
 * <p>
 * 5、@RequestMapping 注解的 headers 属性
 * 作用：通过请来的请求头信息匹配请求，即浏览器发送的请求的请求头信息必须满足 headers 属性的设置
 * headers 可以使用四种表达式：
 * "header"：表示当前所匹配请的请求参数中必须携带 header 参数
 * "!header"：表示当前所匹配请求的请求参数中一定不能携带 header 参数
 * "header=value"：表示当前所匹配请求的请求参数中必须携带 header 参数且值必须为 value
 * "header!=value"：表示当前所匹配请求的请求参数中可以不携带 header，若携带值一定不能是 value
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求头信息不匹配
 * 此时页面报错：HTTP 状态 404 - The requested resource is not available.
 * <p>
 * 6、SpringMVC 支持 ant 风格的路径
 * 在 @RequestMapping 注解的 value 属性值中设置一些特殊字符
 * ?：任意的单个字符（不包括 ? 和 /）
 * *：任意个数的任意字符（不包括 ? 和 /）
 * **：任意层数的任意目录，注意使用方式只能 / ** /，** 写在双斜线中，前后不能有任何的其他字符
 * <p>
 * 7、@RequestMapping 注解使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest：/user/delete/1
 * 需要在 @RequestMapping 注解的 value 属性中所设置的路径中，使用(xx}的方式表示路径中的数据
 * 在通过 @PathVariable 注解，将位符所标识的值和控制器方法的形参进行绑定
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController
{
    // 此时控制器方法所匹配的请求的请路径为 /test/hello
    @RequestMapping(
            value = {"/hello", "/hello2"},
            method = {RequestMethod.POST, RequestMethod.GET},
            // params = {"username", "!password", "age=21", "gender!=女"}
            headers = {"Referer"}
    )
    public String hello()
    {
        return "success";
    }

    @RequestMapping("/ant/**")
    public String testAnt()
    {
        return "success";
    }

    @RequestMapping("/rest/{id}/{username}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username)
    {
        System.out.println("id = " + id);
        System.out.println("username = " + username);

        return "success";
    }
}
