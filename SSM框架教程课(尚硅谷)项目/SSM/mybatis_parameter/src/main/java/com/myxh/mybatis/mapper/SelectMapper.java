package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/8/13
 * @description: 若 SQL 语句查询的结果为多条时，一定不能以实体类类型作为方法的返回值，
 * 否则会抛出异常 TooManyResultsException
 * 若 SQL 语句查询的结果为 1 条时，此时可以使用实体类类型或 List 集合类型作为方法的返回值
 */
public interface SelectMapper
{
    /**
     * 根据 id 查询用户信息
     *
     * @param id 用户 id
     * @return 一个用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     *
     * @return 所有用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户的总数量
     *
     * @return 用户的总数量
     */
    Integer getUserCount();

    /**
     * 根据 id 查询用户信息为 userMap 集合
     *
     * @param id 用户 id
     * @return 一个用户信息为 userMap 集合
     */
    Map<String, Object> getUserByIdToUserMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息为 userMap 集台
     * 若查询的数据有多条时，并且要将每条数据转换为 map 集合，
     * 此时有两种解决方案:
     * 1、将 mapper 接口方法的返回值设置为泛型是 Map 的 List 集合
     * List<Map<string，object>> getAllUserToUserMap();
     * 结果：[{password=520.ILY!, gender=男, id=1, age=21, email=1735350920@qq.com, username=MYXH}, {password=000000, gender=男, id=2, age=21, email=root@qq.com, username=root}, {password=123456, gender=男, id=3, age=21, email=admin@qq.com, username=admin}]
     * 2、可以将每条数据转换的 map 集合放在一个大的 map 中，但是必须要通过 @MapKey 注解，
     * 将查询的某个字段的值作为大的 map 的键
     * @MapKey("id") Map<String, Object> getAllUserToUserMap();
     * 结果：
     * {
     *      1={password=520.ILY!, gender=男, id=1, age=21, email=1735350920@qq.com, username=MYXH},
     *      2={password=000000, gender=男, id=2, age=21, email=root@qq.com, username=root},
     *      3={password=123456, gender=男, id=3, age=21, email=admin@qq.com, username=admin}
     * }
     * 
     * @return 所有用户信息为 userMap 集合
     */
    // List<Map<String, Object>> getAllUserToUserMap();
    @MapKey("id")
    Map<String, Object> getAllUserToUserMap();
}
