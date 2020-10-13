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
@Api(value="/",tags ="用户接口")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping("/login")
    @ApiOperation(value = "企业用户登录")
    @ApiImplicitParam(name = "enterpriseForm", value = "企业用户登录信息", required = true ,dataType = "EnterpriseForm")
    ResponseVO<EnterpriseVO> login(EnterpriseForm enterpriseForm){

        EnterpriseVO enterpriseVO = enterpriseService.login(enterpriseForm);
        if(enterpriseVO == null){
            return new ResponseVO<EnterpriseVO>(null,"用户名未注册或密码错误");
        }else{
            return new ResponseVO<>(enterpriseVO);
        }
    }

    @PostMapping("/{id}/getEpById")
    @ApiOperation(value = "检索用户信息")
    @ApiImplicitParam(name = "id", value = "企业用户Id", required = true ,dataType = "Integer")
    ResponseVO<EnterpriseVO> getEnterpriseById(@PathVariable Integer id){
        return new ResponseVO<EnterpriseVO>(enterpriseService.getEnterpriseById(id));
    }

    @PostMapping("/register")
    @ApiOperation(value = "企业注册")
    @ApiImplicitParam(name = "enterpriseVO", value = "企业注册信息", required = true ,dataType = "EnterpriseVO")
    ResponseVO register(@RequestBody  EnterpriseVO enterpriseVO){
        int effect = enterpriseService.createNewEnterPrise(enterpriseVO);
        if(effect>0){
            return new ResponseVO<>(true);
        }else{
            return new ResponseVO<Boolean>(null,"注册失败");
        }
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新企业信息")
    @ApiImplicitParam(name = "enterpriseVO", value = "企业更新信息", required = true ,dataType = "EnterpriseVO")
    ResponseVO updateEnterprise(@RequestBody EnterpriseVO enterpriseVO){
        int effect  = enterpriseService.updateEnterprise(enterpriseVO);
        if(effect>0){
            return new ResponseVO<>(true);
        }else{
            return new ResponseVO<>(null,"更新失败");
        }
    }

    @GetMapping("/{id}/delete")
    @ApiOperation(value = "删除企业信息")
    @ApiImplicitParam(name = "id", value = "被删除企业Id", required = true ,dataType = "Integer")
    ResponseVO deleteEnterprise(@PathVariable Integer id){
        int effect = enterpriseService.deleteEnterPrise(id);
        if(effect>0){
            return new ResponseVO<>(true);
        }else{
            return new ResponseVO<>(null,"更新失败");
        }
    }
}
