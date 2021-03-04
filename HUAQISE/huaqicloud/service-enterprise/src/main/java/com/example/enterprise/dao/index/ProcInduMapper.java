package com.example.enterprise.dao.index;

import com.example.enterprise.po.index.integrate.MassDiscrete;
import com.example.enterprise.po.index.integrate.MixIndustry;
import com.example.enterprise.po.index.integrate.ProcIndustry;
import com.example.enterprise.po.index.integrate.ProcPercent;
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

    /**
     * @param enterprise_id
     * @return
     */
    ProcPercent getPercentByEpId(@Param("enterprise_id")Integer enterprise_id);

    /**
     * @return
     */
    List<ProcPercent> getAllPercent();

    /**
     * 删除表中指定元素
     * @param id
     * */
    int deleteDiverById(@Param("id") Integer id);

    /**
     * 插入指标百分比
     * */
    int updateProcPercent(ProcPercent procPercent);
}
