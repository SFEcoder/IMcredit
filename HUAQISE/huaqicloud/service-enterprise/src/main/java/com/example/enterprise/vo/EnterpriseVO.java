package com.example.enterprise.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:
 * @Date: 2020/10/11 19:44
 */
@Data
public class EnterpriseVO implements Serializable {

    /**
     * 数据库主键
     */
    private Integer id;



    /**
     * 用户类型，0代表普通用户，1代表企业用户
     */
    private Integer userType;

    /**
     * 企业密码
     */
    private String password;

    /**
     *  企业名字
     */
    private String name;

    /**
     * 注册号
     */
    private String registerNumber;

    /**
     * 联系人名字
     */
    private String contactName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 营业执照
     */
    private String license;

    /**
     * 联系号码
     */
    private String contactNumber;

    /**
     * 是否有效
     */
    private boolean valid;

    /**
     * 企业的评级，默认0为最高
     */
    private Integer eGrade;

    /**
     * 企业照片
     */
    private String ePhoto;

}

