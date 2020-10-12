package com.example.enterprise.controller.enterprise;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.po.Enterprise;
import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:
 * @Date: 2020/10/12 0:04
 */
@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;


    @PostMapping("/login")
    ResponseVO login(EnterpriseForm enterpriseForm){
        return enterpriseService.login(enterpriseForm);
    }

    @PostMapping("/{id}/getEpById")
    ResponseVO getEnterpriseById(@PathVariable Integer id){
        return ResponseVO.buildSuccess(enterpriseService.getEnterpriseById(id));
    }

    @PostMapping("/register")
    ResponseVO register(@RequestBody  EnterpriseVO enterpriseVO){
        return enterpriseService.createNewEnterPrise(enterpriseVO);
    }

    @PostMapping("/update")
    ResponseVO updateEnterprise(@RequestBody EnterpriseVO enterpriseVO){
        return enterpriseService.updateEnterprise(enterpriseVO);
    }

    @GetMapping("/{id}/delete")
    ResponseVO deleteEnterprise(@PathVariable Integer id){
        return enterpriseService.deleteEnterPrise(id);
    }
}
