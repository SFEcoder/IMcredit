package com.example.enterprise.blImpl.enterprise;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.dao.enterprise.EnterpriseMapper;
import com.example.enterprise.po.Enterprise;
import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Date: 2020/10/11 20:21
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private static final String SIGN_UP_FAIL = "注册企业失败";

    private static final String SIGN_UP_SUCCESS = "注册企业成功";

    private static final String UPDATE_FAILURE = "更新企业信息失败！";

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public ResponseVO login(EnterpriseForm enterpriseForm) {
        String email=enterpriseForm.getEmail();
        String password = enterpriseForm.getPassword();
        Enterprise enterprise=enterpriseMapper.getEnterpriseByEmail(email);
        if(enterprise == null){
            return ResponseVO.buildFailure("该邮箱地址无效");
        }else if(!password.equals(enterprise.getPassword())){
            return ResponseVO.buildFailure("输入密码不正确，请重新输入");
        }else{
            EnterpriseVO enterpriseVO=new EnterpriseVO();
            BeanUtils.copyProperties(enterprise,enterpriseVO);
            return ResponseVO.buildSuccess(enterpriseVO);
        }

    }

    @Override
    public ResponseVO createNewEnterPrise(EnterpriseVO enterpriseVO) {
        Enterprise enterprise=new Enterprise();
        BeanUtils.copyProperties(enterpriseVO,enterprise);
        try {
            enterpriseMapper.insertEnterprise(enterprise);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(SIGN_UP_FAIL);
        }
        return ResponseVO.buildSuccess(SIGN_UP_SUCCESS);
    }

    @Override
    public ResponseVO deleteEnterPrise(Integer id) {
        try {
            enterpriseMapper.deleteEnterprise(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("删除企业失败");
        }
        return ResponseVO.buildSuccess("删除企业成功");
    }

    @Override
    public EnterpriseVO getEnterpriseById(Integer id) {
        Enterprise enterprise = enterpriseMapper.getEnterpriseById(id);
        if (null == enterprise){
            return null;
        } else {
           EnterpriseVO enterpriseVO = new EnterpriseVO();
           BeanUtils.copyProperties(enterprise,enterpriseVO);
           return enterpriseVO;
        }
    }

    @Override
    public ResponseVO updateEnterprise(EnterpriseVO enterpriseVO) {
        if (null == enterpriseVO){
            return ResponseVO.buildFailure(UPDATE_FAILURE);
        }else {
            Enterprise enterprise = new Enterprise();
            BeanUtils.copyProperties(enterpriseVO,enterprise);
            try {
                enterpriseMapper.updateEnterprise(enterprise);
            }catch (Exception e){
                System.out.println(e.getMessage());
                return ResponseVO.buildFailure(UPDATE_FAILURE);
            }
        }

        return ResponseVO.buildSuccess("更新成功");
    }


}
