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
     * 企业的评级，默认0为最高,-1代表未评分
     */
    private Integer eGrade;

    /**
     * 企业照片
     */
    private String ePhoto;


    /**
     * 企业所处行业类型，共有5种，分别是离散大批量行业
     */
    private Integer type;

    /**
     * 财务指标评分
     */
    private Double financialScore;

    /**
     * 两化指标评分
     */
    private Double diverScore;

    /**
     * 总信用得分
     */
    private  Double totalScore;


}

