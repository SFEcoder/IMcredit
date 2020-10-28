package com.example.enterprise.bl.index;

import com.example.enterprise.vo.EnterpriseTarget;
import com.example.enterprise.vo.TargetObject;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/24 16:32
 */
public interface IndexService {

    /**
     * 企业添加指标
     * @param id
     * @param enterpriseTarget
     * */
    Integer addEnterpriseTarget(Integer id, EnterpriseTarget enterpriseTarget);

    /**
     * 企业更新财务指标
     * @param id
     * @param targetObject 财务指标数组
     * */
    Integer updateEnterpriseFinanTarget(Integer id, TargetObject targetObject);

    /**
     * 企业更新两化指标
     * @param id
     * @param targetObject 两化指标数组
     * */
    Integer updateEnterpriseDiverTarget(Integer id, TargetObject targetObject);

    /**
     * 获取企业财务、两化指标
     * */
    Double[][] getEnterpriseTarget(Integer id);
}
