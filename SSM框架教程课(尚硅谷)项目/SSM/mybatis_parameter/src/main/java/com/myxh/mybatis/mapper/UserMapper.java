package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/8/13
 * @description: MyBatis 获取参数值的两种方式：#{} 和 ${}
 * #{} 的本质是占位符赋值，${} 的本质是字符串拼接
 * 1、若 mapper 接口方法的参数为单个的字面量类型，
 * 此时可以通过 #{} 和 ${} 以任意的内容获取参数值，一定要注意 ${} 的单引号问题
 * 2、若 mapper 接口方法的参数为多个的字面量类型，
 * 此时 MyBatis 会将参数放在 map 集合中，以两种方式存储数据
 * ① 以 arg0，arg1 ... 为键，以参数为值
 * ② 以 param1，param2 ... 为键，以参数为值
 * 因此，只需要通过 #{} 和 ${} 访问 map 集合的键，就可以获取相对应的值，一定要注意 ${} 的单引号问题
 * 3、若 mapper 接口方法的参数为 map 集合类型的参数，
 * 只需要通过 #{} 和 ${} 访问 map 集合的键，就可以获取相对应的值，一定要注意 ${} 的单引号问题
 * 4、若 mapper 接口方法的参数为实体类类型的参数，
 * 只需要通过 #{}和 ${} 访问实体类中的属性名，就可以获职相对应的属性值，一定要注意 ${} 的单引号问题
 * 5、可以在 mapper 接口方法的参数上设置 @Param 注解，
 * 此时 MyBatis 会将这些参数放在 map 集合中，以两种方式进行存储
 * ① 以 {@code @Param} 注解的 value 属性值为键，以参数为值
 * ② 以 param1，param2 ... 为键，以参数为值
 * 因此，只需要通过 #{} 和 ${} 访问 map 集合的键，就可以获取相对应的值，一定要注意 ${} 的单引号问题
 */
public interface UserMapper
{
    /**
     * 根据 username 查询用户信息
     *
     * @param username 用户名
     * @return 一个用户信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 一个用户信息
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录（以 userMap 集合作为参数）
     *
     * @param userMap 用户集合（用户名、用户密码）
     * @return 一个用户信息
     */
    User checkLoginByUserMap(Map<String, Object> userMap);

    /**
     * 添加用户信息
     *
     * @param user 用户信息
     * @return 影响的行数
     */
    int insertUser(User user);

    /**
     * 验证登录（使用 @Param 注解）
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 一个用户信息
     */
    User checkLoginByUserParam(@Param("username") String username, @Param("password") String password);
}
