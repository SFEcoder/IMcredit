package com.example.enterprise.controller.enterprise;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:
 * @Date: 2020/10/12 0:04
 */
@RestController
@RequestMapping("/api/enterprise")
@Api(value="/",tags ="企业接口")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping("/login")
    @ApiOperation(value = "企业用户登录")
    @ApiImplicitParam(name = "enterpriseForm", value = "企业用户登录信息", required = true ,dataType = "EnterpriseForm")
    ResponseVO login(EnterpriseForm enterpriseForm){

        EnterpriseVO enterpriseVO = enterpriseService.login(enterpriseForm);
        if(enterpriseVO == null){
            return ResponseVO.buildFailure("用户名未注册或密码错误");
        }else{
            return ResponseVO.buildSuccess(enterpriseVO);
        }
    }

    @PostMapping("/{id}/getEpById")
    @ApiOperation(value = "检索用户信息")
    @ApiImplicitParam(name = "id", value = "企业用户Id", required = true ,dataType = "Integer")
    ResponseVO getEnterpriseById(@PathVariable Integer id){

        EnterpriseVO  enterpriseVO = enterpriseService.getEnterpriseById(id);
        if(null == enterpriseVO){
            return ResponseVO.buildFailure("用户信息为空");
        }else{
            return ResponseVO.buildSuccess(enterpriseVO);
        }
    }

    @PostMapping("/register")
    @ApiOperation(value = "企业注册")
    @ApiImplicitParam(name = "enterpriseVO", value = "企业注册信息", required = true ,dataType = "EnterpriseVO")
    ResponseVO register(@RequestBody  EnterpriseVO enterpriseVO){
        int effect = enterpriseService.createNewEnterPrise(enterpriseVO);
        if(effect>0){
            return ResponseVO.buildSuccess("注册成功");
        }else{
            return ResponseVO.buildFailure("注册失败");
        }
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新企业信息")
    @ApiImplicitParam(name = "enterpriseVO", value = "企业更新信息", required = true ,dataType = "EnterpriseVO")
    ResponseVO updateEnterprise(@RequestBody EnterpriseVO enterpriseVO){
        int effect  = enterpriseService.updateEnterprise(enterpriseVO);
        if(effect>0){
            return ResponseVO.buildSuccess("更新成功");
        }else{
            return ResponseVO.buildFailure("更新失败");
        }
    }

    @GetMapping("/{id}/delete")
    @ApiOperation(value = "删除企业信息")
    @ApiImplicitParam(name = "id", value = "被删除企业Id", required = true ,dataType = "Integer")
    ResponseVO deleteEnterprise(@PathVariable Integer id){
        int effect = enterpriseService.deleteEnterPrise(id);
        if(effect>0){
            return ResponseVO.buildSuccess("更新成功");
        }else{
            return ResponseVO.buildSuccess("更新失败");
        }
    }

    @GetMapping("/getEnterpriseImgList")
    @ApiOperation(value = "获取企业图片url，至多20个")
    ResponseVO getEnterpriseImgList(){
        return ResponseVO.buildSuccess(enterpriseService.getEnterpriseImgList());
    }
}
