package com.example.enterprise.dao.index;

import com.example.enterprise.po.index.integrate.ServeIndustry;
import com.example.enterprise.po.index.integrate.SmeDiscrete;
import com.example.enterprise.po.index.integrate.SmePercent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zzx
 * @Date: 2020/10/24 0:05
 */
@Mapper
@Repository
public interface SmeDisMapper {

    /**
     * 插入中小型离散化企业两化指标
     * @param smeDiscrete
     * @return
     */
    int insertSmeDis(SmeDiscrete smeDiscrete);

    /**
     * 根据企业id获得中小型离散化行业两化指标
     * @param enterprise_id
     * @return
     */
    SmeDiscrete getSmeDisByEpId(@Param("enterprise_id")Integer enterprise_id);

    /**
     * 获取所有的中小型离散化行业两化指标，用于计算企业信用评分
     * @return
     */
    List<SmeDiscrete> getAllSmeDis();

    /**
     * @param enterprise_id
     * @return
     */
    SmePercent getPercentByEpId(@Param("enterprise_id")Integer enterprise_id);

    /**
     * @return
     */
    List<SmePercent> getAllPercent();

    /**
     * 删除表中指定元素
     * @param id
     * */
    int deleteDiverById(@Param("id") Integer id);

    /**
     * 插入指标百分比
     * */
    int updateSmePercent(SmePercent smePercent);
}
