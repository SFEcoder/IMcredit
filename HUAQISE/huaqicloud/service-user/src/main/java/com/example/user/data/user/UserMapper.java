package com.example.user.data.user;


import com.example.user.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: zzx
 * @Date: 2020/9/2 11:04
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * description: 根据用户id返回用户信息
     *
     * @param id
     * @return com.example.credit.po.User
     */
    User getUserById(@Param("id") Integer id);

    /**
     * description: 根据用户email获取用户信息
     *
     * @param email
     * @return com.example.credit.po.User
     */
    User getUserByEmail(@Param("email") String email);

    /**
     * description: 创建新的用户，当用户邮箱重复时无法插入成功
     *
     * @param user
     * @return int
     */
    int createNewUser(User user);

    /**
     * description: 用户注销账户
     *
     * @param id
     * @return int
     */
    int deleteUserById(@Param("id") Integer id);

    /**
     * description: 用户更新信息
     *
     * @param user
     * @return int
     */
    int updateUser(User user);
}
