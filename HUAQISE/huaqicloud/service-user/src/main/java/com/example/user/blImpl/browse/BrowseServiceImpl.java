package com.example.user.blImpl.browse;

import com.example.user.bl.browse.BrowseService;
import com.example.user.data.browse.BrowseMapper;
import com.example.user.dto.browse.BrowseDto;
import com.example.user.po.Browse;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:
 * @Date: 2020/10/13 19:40
 */
@Service
public class BrowseServiceImpl implements BrowseService {

    @Autowired
    private BrowseMapper browseMapper;

    @Override
    public List<BrowseDto> getBrowseByUid(Integer userId) {
        List<Browse> browses=browseMapper.selectBrowseByUid(userId);

        return browses.stream().map(browse -> {
            BrowseDto browseDto = new BrowseDto();
            BeanUtils.copyProperties(browse,browseDto);
            return browseDto;
        }).collect(Collectors.toList());
    }

    @Override
    public int insertBrowse(BrowseDto browseDto) {
        Browse browse=browseMapper.existBrowse(browseDto.getUserId(),browseDto.getEpId());
        if(null == browse){
            browse = new Browse();
            BeanUtils.copyProperties(browseDto,browse);
            return browseMapper.insertBrowse(browse);
        }else{
            browse = new Browse();
            BeanUtils.copyProperties(browseDto,browse);
            return browseMapper.updateBrowse(browse);
        }
    }

    @Override
    public int deleteBrowse(Integer userId, Integer epId) {
        return browseMapper.deleteBrowse(userId,epId);
    }
}
