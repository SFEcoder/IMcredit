package com.example.user.bl.user;

import com.example.user.vo.UserForm;
import com.example.user.vo.UserVO;
import com.example.common.vo.ResponseVO;

/**
 * @Author: zzx
 * @Date: 2020/9/2 11:03
 */
public interface UserService {

    /**
     * description: 登录
     *
     * @param userForm
     * @return com.example.credit.com.example.common.vo.ResponseVO
     */
    ResponseVO login(UserForm userForm);

    /**
     * description: 注册创建新用户
     *
     * @param userVO
     * @return com.example.credit.com.example.common.vo.UserVO
     */
    ResponseVO createUser(UserVO userVO);

    /**
     * description: 更新用户信息
     *
     * @param userVO
     * @return com.example.credit.com.example.common.vo.UserVO
     */
    ResponseVO updateUser(UserVO userVO);

    /**
     * description: 根据用户id删除用户
     *
     * @param id
     * @return com.example.credit.com.example.common.vo.ResponseVO
     */
    ResponseVO deleteUserById(Integer id);

    /**
     * description: 根据id返回相应的用户信息
     *
     * @param id
     * @return com.example.credit.com.example.common.vo.UserVO
     */
    UserVO getUserInfo(Integer id);

}
