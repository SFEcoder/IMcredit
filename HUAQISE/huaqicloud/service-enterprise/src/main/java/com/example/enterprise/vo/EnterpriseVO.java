package com.example.enterprise.vo;

import lombok.Data;

/**
 * @Author:
 * @Date: 2020/10/11 19:44
 */
@Data
public class EnterpriseVO {

    /**
     * 数据库主键
     */
    private Integer id;



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

}

