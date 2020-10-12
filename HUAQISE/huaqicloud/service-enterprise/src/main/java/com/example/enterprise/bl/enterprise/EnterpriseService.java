package com.example.enterprise.bl.enterprise;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.po.Enterprise;
import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;

/**
 * @Author:
 * @Date: 2020/10/11 19:55
 */
public interface EnterpriseService {

    /**
     * 企业用户登录
     * @param enterpriseForm
     * @return
     */
     ResponseVO login(EnterpriseForm enterpriseForm);

    /**
     * 注册新的企业
     * @param enterpriseVO
     * @return
     */
     ResponseVO createNewEnterPrise(EnterpriseVO enterpriseVO);

    /**
     * 从数据库中删除某个企业
     * @param id
     * @return
     */
     ResponseVO deleteEnterPrise(Integer id);

    /**
     * 根据Id去获取某个企业
     * @param id
     * @return
     */
     EnterpriseVO getEnterpriseById(Integer id);


    /**
     * 更新企业信息
     * @param enterpriseVO
     * @return
     */
     ResponseVO updateEnterprise(EnterpriseVO enterpriseVO);
}
