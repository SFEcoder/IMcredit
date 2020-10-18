package com.example.enterprise.dao.enterprise;

import com.example.enterprise.po.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/11 19:47
 */
@Mapper
@Repository
public interface EnterpriseMapper {

    /**
     * 根据id获取企业信息
     * @param id
     * @return
     */
    Enterprise getEnterpriseById(@Param("id")Integer id);


    /**
     * 根据email获取企业信息,用于登录判断
     * @param email
     * @return
     */
    Enterprise getEnterpriseByEmail(@Param("email")String email);
    /**
     * 添加一个企业
     * @param enterprise
     * @return
     */
    int insertEnterprise(Enterprise enterprise);

    /**
     * 删除一个企业
     * @param id
     * @return
     */
    int deleteEnterprise(@Param("id") Integer id);

    /**
     * 更新一个企业
     * @param enterprise
     * @return
     */
    int updateEnterprise(Enterprise enterprise);

    /**
     * 获取至多20个企业
     * @return
     */
    List<Enterprise> getTwentyEnterprises();

}
