package com.example.enterprise.dao.index;

import com.example.enterprise.po.index.financial.FinancialIndex;
import com.example.enterprise.po.index.integrate.MassDiscrete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/24 0:03
 */
@Mapper
@Repository
public interface MassDisMapper {


    /**
     * 插入离散大批量企业两化指标
     * @param massDiscrete
     * @return
     */
    int insertMassDis(MassDiscrete massDiscrete);

    /**
     * 根据企业id获得离散大批量两化指标
     * @param enterprise_id
     * @return
     */
    MassDiscrete getMassDisByEpId(@Param("enterprise_id")Integer enterprise_id);

    /**
     * 获取所有的离散大批量两化指标，用于计算企业信用评分
     * @return
     */
    List<MassDiscrete> getAllMassDis();
}