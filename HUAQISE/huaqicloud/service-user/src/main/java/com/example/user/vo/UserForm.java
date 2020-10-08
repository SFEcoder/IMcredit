package com.example.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzx
 * @Date: 2020/9/2 11:38F
 */
@Data
public class UserForm implements Serializable {

    /**
     * 用户邮箱，不可重复
     */
    private String email;
    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户类型，后续 可用枚举类代替
     */
    private String userType;

}
