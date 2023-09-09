package com.myxh.springmvc.controller;

import com.myxh.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MYXH
 * @date 2023/9/1
 * @deprecated
 * 获取请求参数的方式：
 * 1、通过 ServletAPI 获获取
 * 只需要在控制器方法的形参位置设置 HttpServletRequest 类型的形参
 * 就可以在控制器方法中使用 request 对象获取请求参数
 * <p>
 * 2、通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 * <p>
 * 3、@RequestParam: 将请求参数和控制器方法的形参绑定
 * {@code @RequestParam} 注解的三个属性: value, required, defaultValue
 * value：设置和形参绑定的请参数的名宇
 * required：设置是否必须传输 vaLue 所对应的请求参数
 * 默认值为 true，表示 value 所对应的请求参数必须传输，否则页面报错：
 * HTTP 状态 400 - Required string parameter 'xxx' is not present
 * 若设置为 false，则表示 value 所对应的请求参数不是必须传输，若为传输，则形参值为 null
 * defaultValue：设置当没有传输 value 所对应的请求参数时，为形参设置的默认值，此时和 required 属性值无关
 * <p>
 * 4、@RequestHeader：请求头信息和控制器方法的形参绑定
 * {@code @RequestHeader} 注解的三个属性: value, required, defaultValue
 * <p>
 * 5、@CookieValue：cookie 数据和控制器方法的形参绑定
 * {@code @CookieValue} 注解的三个属性: value, required, defaultValue
 * <p>
 * 6、通过控制器方法的实体类类型的形参获取请求参数
 * 需要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中的属性的属性名和请求参数的名字一致
 * 可以通过实体类类型的形参获取请求参数
 * <p>
 * 7、解决获取请求此参数的乱码问题
 * 在 web.xml 中配置 Spring 的编码过滤器 characterEncodingFilter
 */
@Controller
public class TestParamController
{
    @RequestMapping("/param/servlet/api")
    public String getParamByServletAPI(HttpServletRequest request)
    {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "name", required = true, defaultValue = "MYXH") String username,
                           String password,
                           @RequestHeader("Referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId
    )
    {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("referer = " + referer);
        System.out.println("jsessionId = " + jsessionId);

        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user)
    {
        System.out.println("user = " + user);

        return "success";
    }
}
