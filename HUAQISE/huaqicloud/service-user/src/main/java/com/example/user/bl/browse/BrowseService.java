package com.example.user.bl.browse;

import com.example.user.dto.browse.BrowseDto;
import com.example.user.po.Browse;

import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/13 19:40
 */
public interface BrowseService {

    /**
     * 获取用户的浏览记录
     * @param userId
     * @return
     */
    List<BrowseDto> getBrowseByUid(Integer userId);

    /**
     * 插入一条新的浏览记录
     * @param browseDto
     * @return
     */
    int insertBrowse(BrowseDto browseDto);

    /**
     * 删除一条浏览记录
     * @param userId
     * @param upId
     * @return
     */
    int deleteBrowse(Integer userId,Integer upId);

}
