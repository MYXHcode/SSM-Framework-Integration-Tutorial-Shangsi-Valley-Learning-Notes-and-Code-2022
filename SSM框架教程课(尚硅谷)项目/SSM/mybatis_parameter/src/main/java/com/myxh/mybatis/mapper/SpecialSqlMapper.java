package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/13
 */
public interface SpecialSqlMapper
{
    /**
     * 通过用户名模糊查询用户信息
     *
     * @param vagueUsername 模糊用户名
     * @return 一些用户信息
     */
    List<User> getUserByLikeUsername(@Param("vagueUsername") String vagueUsername);

    /**
     * 批量删除用户信息
     *
     * @param ids 一些用户 id
     * @return 影响的行数
     */
    int deleteMoreUserByIds(@Param("ids") String ids);

    /**
     * 动态设置表名，查询用户信息
     *
     * @param tableName 动态表名
     * @return 一些用户信息
     */
    List<User> getUserByTableNameToList(@Param("tableName") String tableName);

    /**
     * 添加用户信息并获取自增的主键
     *
     * @param user 用户信息
     * @return 影响的行数
     */
    int insertUser(User user);
}
