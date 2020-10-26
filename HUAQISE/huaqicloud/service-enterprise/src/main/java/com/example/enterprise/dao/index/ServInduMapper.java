package com.example.enterprise.dao.index;

import com.example.enterprise.po.index.integrate.MassDiscrete;
import com.example.enterprise.po.index.integrate.ProcIndustry;
import com.example.enterprise.po.index.integrate.ServeIndustry;
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
public interface ServInduMapper {

    /**
     * 插入混合行业企业两化指标
     * @param serveIndustry
     * @return
     */
    int insertServIndu(ServeIndustry serveIndustry);

    /**
     * 根据企业id获得服务行业两化指标
     * @param enterprise_id
     * @return
     */
    ServeIndustry getSerIndByEpId(@Param("enterprise_id")Integer enterprise_id);

    /**
     * 获取所有的服务行业两化指标，用于计算企业信用评分
     * @return
     */
    List<ServeIndustry> getAllSerInd();

    /**
     * 删除表中指定元素
     * @param id
     * */
    int deleteDiverById(@Param("id") Integer id);
}
