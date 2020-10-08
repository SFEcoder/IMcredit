package com.example.user.po;

import lombok.Data;

/**
 * @Author: zzx
 * @Date: 2020/9/2 10:55
 */
@Data
public class User {

    private Integer id;

    private String email;

    private String password;

    private String username;

    private String phoneNumber;

    /**
     * 用户类型， 后期可用 枚举类 代替
     */
    private String userType;

    /**
     * 用户头像 Url
     */
    private String avatarUrl;

}
