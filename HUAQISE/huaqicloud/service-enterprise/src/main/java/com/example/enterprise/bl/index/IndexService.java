package com.example.enterprise.bl.index;

import com.example.enterprise.vo.EnterpriseTarget;

/**
 * @Author:
 * @Date: 2020/10/24 16:32
 */
public interface IndexService {

    /**
     * 企业添加指标
     * @param id
     * @param div 两化指标数组
     * @param fin 财务指标数组
     * */
    Integer addEnterpriseTarget(Integer id, EnterpriseTarget enterpriseTarget);

    /**
     * 企业更新财务指标
     * @param id
     * @param fin 财务指标数组
     * */
    Integer updateEnterpriseFinanTarget(Integer id, Double[] fin);

    /**
     * 企业更新两化指标
     * @param id
     * @param div 两化指标数组
     * */
    Integer updateEnterpriseDiverTarget(Integer id, Double[] div);

    /**
     * 获取企业财务、两化指标
     * */
    Double[][] getEnterpriseTarget(Integer id);
}
