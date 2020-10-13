package com.example.user.vo;

import com.example.enterprise.vo.EnterpriseVO;
import lombok.Data;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/13 19:02
 */
@Data
public class BrowseVO {
    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 浏览的企业信息,用于前端展示
     */
    private EnterpriseVO enterpriseVO;

    /**
     * 浏览的时间
     */
    private String createTime;
}
