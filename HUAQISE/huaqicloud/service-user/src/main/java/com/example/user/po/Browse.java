package com.example.user.po;

import lombok.Data;

/**
 * 用户浏览记录
 * @Author: zzx
 * @Date: 2020/10/13 19:01
 */
@Data
public class Browse {

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 浏览的企业Id
     */
    private Integer epId;

    /**
     * 浏览的时间
     */
    private String createTime;
}
