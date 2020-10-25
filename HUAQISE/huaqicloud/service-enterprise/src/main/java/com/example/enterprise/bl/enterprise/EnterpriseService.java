package com.example.enterprise.bl.enterprise;

import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;

import java.util.List;

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
     EnterpriseVO login(EnterpriseForm enterpriseForm);

    /**
     * 注册新的企业
     * @param enterpriseVO
     * @return
     */
     Integer createNewEnterPrise(EnterpriseVO enterpriseVO);

    /**
     * 从数据库中删除某个企业
     * @param id
     * @return
     */
    Integer deleteEnterPrise(Integer id);

    /**
     * 根据Id去获取某个企业
     * @param id
     * @return
     */
     EnterpriseVO getEnterpriseById(Integer id) ;


    /**
     * 更新企业信息
     * @param enterpriseVO
     * @return
     */
     Integer updateEnterprise(EnterpriseVO enterpriseVO);

    /**
     * 随机获取20条企业的图像List
     * @return
     */
     List<String> getEnterpriseImgList();


    /**
     * 根据关键词进行搜索
     * @param key
     * @return
     */
     List<EnterpriseVO> searchEpByKey(String key);
}
