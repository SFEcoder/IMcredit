package com.example.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzx
 * @Date: 2020/9/2 11:01
 */
@Data
public class UserVO implements Serializable {

    private Integer id;

    private String email;

    private String password;

    private String username;

    private String phoneNumber;

    /**
     * 用户类型,0代表用户，1代表企业
     */
    private Integer userType;

    /**
     * 用户头像 Url
     */
    private String avatarUrl;

}
