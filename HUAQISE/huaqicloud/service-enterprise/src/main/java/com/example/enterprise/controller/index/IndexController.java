package com.example.enterprise.controller.index;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.bl.index.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Owen
 * @Date: 2020/10/25 13:31
 * @Description:
 */
@RestController
@RequestMapping("/api/index")
@Api(value="/",tags ="指标接口")
public class IndexController {

    @Autowired
    IndexService indexService;

    @PostMapping("/{id}/add_target")
    ResponseVO addEnterpriseTarget(@PathVariable Integer id, @RequestParam("div")Double[] div, @RequestParam("fin")Double[] fin) {
        int effect = indexService.addEnterpriseTarget(id, div, fin);
        if (effect > 0){
            return ResponseVO.buildSuccess("成功添加指标");
        }else{
            return ResponseVO.buildFailure("添加指标异常");
        }
    }

    @PostMapping("/{id}/update_fin_target")
    @ApiOperation("更新财务指标")
    ResponseVO updateEnterpriseFinanTarget(@PathVariable Integer id, @RequestParam("fin")Double[] fin){
        int effect = indexService.updateEnterpriseFinanTarget(id, fin);
        if (effect > 0){
            return ResponseVO.buildSuccess("成功添加指标");
        }else{
            return ResponseVO.buildFailure("添加指标异常");
        }
    }

    @PostMapping("/{id}/update_div_target")
    @ApiOperation("更新两化指标")
    ResponseVO updateEnterpriseDiverTarget(@PathVariable Integer id, @RequestParam("div")Double[] div){
        int effect = indexService.updateEnterpriseDiverTarget(id, div);
        if (effect > 0){
            return ResponseVO.buildSuccess("成功添加指标");
        }else{
            return ResponseVO.buildFailure("添加指标异常");
        }
    }

    @GetMapping("/{id}/get_target")
    ResponseVO getEnterpriseTarget(@PathVariable Integer id){
        Double[][] arrays = indexService.getEnterpriseTarget(id);
        if (arrays==null){
            return ResponseVO.buildFailure("该企业还未添加指标");
        }
        return ResponseVO.buildSuccess(arrays);
    }
}
