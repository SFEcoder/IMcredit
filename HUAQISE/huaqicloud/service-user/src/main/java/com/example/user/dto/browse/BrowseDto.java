package com.example.user.dto.browse;

import lombok.Data;

/**
 * @Author:
 * @Date: 2020/10/13 19:43
 */
@Data
public class BrowseDto {

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
