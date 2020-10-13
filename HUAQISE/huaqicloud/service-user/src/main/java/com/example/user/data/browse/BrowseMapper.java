package com.example.user.data.browse;

import com.example.user.po.Browse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/13 19:12
 */
@Mapper
@Repository
public interface BrowseMapper {

    /**
     * 插入一条 浏览记录
     * @param browse
     * @return
     */
    int insertBrowse(Browse browse);

    /**
     * 更新浏览记录的时间
     * @param browse
     * @return
     */
    int updateBrowse(Browse browse);

    /**
     * 删除该浏览记录
     * @param userId
     * @param epId
     * @return
     */
    int deleteBrowse(@Param("userId") Integer userId, @Param("epId") Integer epId);

    /**
     * 获取用户Id
     * @param userId
     * @return
     */
    List<Browse> selectBrowseByUid(@Param("userId") Integer userId);

    /**
     * 判断是否已存在该条浏览记录
     * @param userId
     * @param epId
     * @return
     */
    Browse existBrowse(@Param("userId") Integer userId,@Param("epId") Integer epId);
}
