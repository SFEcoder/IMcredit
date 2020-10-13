package com.example.enterprise.blImpl.enterprise;

import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.dao.enterprise.EnterpriseMapper;
import com.example.enterprise.po.Enterprise;
import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;
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
    public EnterpriseVO login(EnterpriseForm enterpriseForm) {
        String email=enterpriseForm.getEmail();
        String password = enterpriseForm.getPassword();
        Enterprise enterprise=enterpriseMapper.getEnterpriseByEmail(email);
        if(enterprise == null){
            return null;
        }else if(!password.equals(enterprise.getPassword())){
            return null;
        }else{
            EnterpriseVO enterpriseVO=new EnterpriseVO();
            BeanUtils.copyProperties(enterprise,enterpriseVO);
            return enterpriseVO;
        }

    }

    @Override
    public Integer createNewEnterPrise(EnterpriseVO enterpriseVO) {
        Enterprise enterprise=new Enterprise();
        BeanUtils.copyProperties(enterpriseVO,enterprise);
        return enterpriseMapper.insertEnterprise(enterprise);
    }

    @Override
    public Integer deleteEnterPrise(Integer id) {
        return enterpriseMapper.deleteEnterprise(id);
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
    public Integer updateEnterprise(EnterpriseVO enterpriseVO) {
        if (null == enterpriseVO){
            return 0;
        }else {
            Enterprise enterprise = new Enterprise();
            BeanUtils.copyProperties(enterpriseVO,enterprise);
            return enterpriseMapper.updateEnterprise(enterprise);
        }
    }


}
