package com.example.enterprise.vo;

import lombok.Data;

/**
 * @Author:
 * @Date: 2020/10/11 20:00
 */
@Data
public class EnterpriseForm {

    /**
     * 企业用户登录的邮箱
     */
    private String email;

    /**
     * 企业登录的密码
     */
    private String password;
}
