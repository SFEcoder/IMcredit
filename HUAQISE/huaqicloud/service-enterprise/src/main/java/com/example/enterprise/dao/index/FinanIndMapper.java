package com.example.enterprise.dao.index;

import com.example.enterprise.po.index.financial.FinancialIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/24 0:02
 */
@Mapper
@Repository
public interface FinanIndMapper {

    /**
     * 插入财务指标
     * @param financialIndex
     * @return
     */
    int insertFinanInd(FinancialIndex financialIndex);

    /**
     * 根据企业id获得经济指标
     * @param enterprise_id
     * @return
     */
    FinancialIndex getFinanByEpId(@Param("enterprise_id")Integer enterprise_id);

    /**
     * 获取所有的经济指标，用于计算企业信用评分
     * @return
     */
    List<FinancialIndex> getAllFinInd();
}
