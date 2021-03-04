package com.example.enterprise.controller.index;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.bl.index.IndexService;
import com.example.enterprise.vo.EnterpriseTarget;
import com.example.enterprise.vo.TargetObject;
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
    ResponseVO addEnterpriseTarget(@PathVariable Integer id, @RequestBody EnterpriseTarget enterpriseTarget) {
        Double[][] arrays = indexService.getEnterpriseTarget(id);
        if (arrays==null){
            int effect = indexService.addEnterpriseTarget(id, enterpriseTarget);
            if (effect > 0){
                return ResponseVO.buildSuccess("成功添加指标");
            }
        }
        else{
            TargetObject update_fin = new TargetObject(enterpriseTarget.getFin());
            TargetObject update_div = new TargetObject(enterpriseTarget.getDiv());
            int f_effect = indexService.updateEnterpriseFinanTarget(id, update_fin);
            int d_effect = indexService.updateEnterpriseDiverTarget(id, update_div);
            if (f_effect > 0 && d_effect > 0){
                return ResponseVO.buildSuccess("成功更新指标");
            }
        }
        return ResponseVO.buildFailure("指标操作异常");

    }

    @PostMapping("/{id}/update_fin_target")
    @ApiOperation("更新财务指标")
    ResponseVO updateEnterpriseFinanTarget(@PathVariable Integer id, @RequestBody TargetObject targetObject){
        int effect = indexService.updateEnterpriseFinanTarget(id, targetObject);
        if (effect > 0){
            return ResponseVO.buildSuccess("成功添加指标");
        }else{
            return ResponseVO.buildFailure("添加指标异常");
        }
    }

    @PostMapping("/{id}/update_div_target")
    @ApiOperation("更新两化指标")
    ResponseVO updateEnterpriseDiverTarget(@PathVariable Integer id, @RequestBody TargetObject targetObject){
        int effect = indexService.updateEnterpriseDiverTarget(id, targetObject);
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
