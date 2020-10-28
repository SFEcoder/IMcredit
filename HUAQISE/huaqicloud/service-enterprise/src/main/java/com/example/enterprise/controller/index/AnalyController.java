package com.example.enterprise.controller.index;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.bl.index.IndexService;
import com.example.enterprise.blImpl.index.IndexServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * @Author: Owen
 * @Date: 2020/10/27 20:54
 * @Description:
 */

@RestController
@RequestMapping("/api/analy")
@Api(value="/",tags ="评析接口")
public class AnalyController {

    @Autowired
    IndexServiceImpl indexService;

    @GetMapping("/{id}/getAnaly")
    ResponseVO getAnaly(@PathVariable Integer id){
        String[] str = indexService.getAnaly(id);
        if (str == null){
            return ResponseVO.buildFailure("获取数组错误");
        }
        return ResponseVO.buildSuccess(str);
    }
}

