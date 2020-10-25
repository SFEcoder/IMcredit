package com.example.enterprise.dao.index;

import com.example.enterprise.po.index.integrate.MassDiscrete;
import com.example.enterprise.po.index.integrate.MixIndustry;
import com.example.enterprise.po.index.integrate.ProcIndustry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/24 0:04
 */
@Mapper
@Repository
public interface ProcInduMapper {

    /**
     * 插入混合行业企业两化指标
     * @param procIndustry
     * @return
     */
    int insertProcIndu(ProcIndustry procIndustry);

    /**
     * 根据企业id获得过程化行业两化指标
     * @param enterprise_id
     * @return
     */
    ProcIndustry getProcByEpId(@Param("enterprise_id")Integer enterprise_id);

    /**
     * 获取所有的过程化行业两化指标，用于计算企业信用评分
     * @return
     */
    List<ProcIndustry> getAllProcInd();
}
