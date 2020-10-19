package com.example.enterprise.blImpl.enterprise;

import com.example.common.cache.RedisCacheClient;
import com.example.common.constant.AesKey;
import com.example.common.utils.AesUtil;
import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.dao.enterprise.EnterpriseMapper;
import com.example.enterprise.po.Enterprise;
import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    private RedisCacheClient redisCacheClient;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public EnterpriseVO login(EnterpriseForm enterpriseForm) {
        String email=enterpriseForm.getEmail();
        String password = AesUtil.decrypt(enterpriseForm.getPassword(), AesKey.getAesKey());
        Enterprise enterprise=enterpriseMapper.getEnterpriseByEmail(email);
        if(enterprise == null){
            return null;
        }else if(!password.equals(enterprise.getPassword())){
            return null;
        }else{
            EnterpriseVO enterpriseVO=new EnterpriseVO();
            BeanUtils.copyProperties(enterprise,enterpriseVO);
            enterpriseVO.setPassword(AesUtil.encrypt(enterprise.getPassword(),AesKey.getAesKey()));
            return enterpriseVO;
        }

    }

    @Override
    public Integer createNewEnterPrise(EnterpriseVO enterpriseVO){
        Enterprise enterprise=new Enterprise();
        enterpriseVO.setPassword(AesUtil.decrypt(enterpriseVO.getPassword(), AesKey.getAesKey()));
        BeanUtils.copyProperties(enterpriseVO,enterprise);
        return enterpriseMapper.insertEnterprise(enterprise);
    }

    @Override
    public Integer deleteEnterPrise(Integer id) {
        redisCacheClient.delete("enterprise_"+id);
        return enterpriseMapper.deleteEnterprise(id);
    }

    @Override
    public EnterpriseVO getEnterpriseById(Integer id) {
        EnterpriseVO enterpriseVO = (EnterpriseVO) redisCacheClient.get("enterprise_"+id);
        if (enterpriseVO==null){
            Enterprise enterprise = enterpriseMapper.getEnterpriseById(id);
            if (null == enterprise){
                return null;
            }
            enterpriseVO = new EnterpriseVO();
            BeanUtils.copyProperties(enterprise,enterpriseVO);
            enterpriseVO.setPassword(AesUtil.encrypt(enterpriseVO.getPassword(), AesKey.getAesKey()));
            redisCacheClient.set("enterprise_"+id, enterpriseVO, 3000);
        }
        return enterpriseVO;
    }

    @Override
    public Integer updateEnterprise(EnterpriseVO enterpriseVO) {
        if (null == enterpriseVO){
            return 0;
        }else {
            redisCacheClient.delete("enterprise_"+enterpriseVO.getId());
            Enterprise enterprise = new Enterprise();
            if(enterpriseVO.getPassword()!=null){
                enterpriseVO.setPassword(AesUtil.decrypt(enterpriseVO.getPassword(), AesKey.getAesKey()));
            }
            BeanUtils.copyProperties(enterpriseVO,enterprise);
            return enterpriseMapper.updateEnterprise(enterprise);
        }
    }

    @Override
    public List<String> getEnterpriseImgList() {
       return enterpriseMapper.getTwentyEnterprises().stream().map(a -> a.getEPhoto()).collect(Collectors.toList());
    }


}
