package com.example.enterprise.blImpl.enterprise;

import com.example.common.cache.RedisCacheClient;
import com.example.common.calculation.Process;
import com.example.common.constant.AesKey;
import com.example.common.utils.AesUtil;
import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.dao.enterprise.EnterpriseMapper;
import com.example.enterprise.dao.index.*;
import com.example.enterprise.po.Enterprise;
import com.example.enterprise.po.index.financial.FinancialIndex;
import com.example.enterprise.po.index.integrate.*;
import com.example.enterprise.vo.EnterpriseForm;
import com.example.enterprise.vo.EnterpriseVO;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private FinanIndMapper finanIndMapper;

    @Autowired
    private MassDisMapper massDisMapper;

    @Autowired
    private MixInduMapper mixInduMapper;

    @Autowired
    private ProcInduMapper procInduMapper;

    @Autowired
    private ServInduMapper servInduMapper;

    @Autowired
    private SmeDisMapper smeDisMapper;

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

    @Override
    public List<EnterpriseVO> searchEpByKey(String key) {
        return enterpriseMapper.getEnterpriseByKey(key).stream().map(a->{
            EnterpriseVO enterpriseVO=new EnterpriseVO();
            a.setPassword(AesUtil.encrypt(a.getPassword(), AesKey.getAesKey()));
            BeanUtils.copyProperties(a,enterpriseVO);
            return enterpriseVO;
        }).collect(Collectors.toList());
    }

    /**
     * @Description 更新同类型企业表中所有评分
     * */
    public void updateTable(Integer id){
        Enterprise e = enterpriseMapper.getEnterpriseById(id);
        int type = e.getType();

        List<Integer> dIDList = new ArrayList<>();
        List<Integer> vIDList = new ArrayList<>();

        // before execute
        List<List<Double>> div = new ArrayList<>();
        List<FinancialIndex> tmpFin = new ArrayList<>();
        List<List<Double>> fin = new ArrayList<>();

        // after execute
        List<Double> divList = new ArrayList<>();
        List<Double> finList = new ArrayList<>();
        List<Double> finalList = new ArrayList<>();

        switch (type){
            case 1:
                List<MassDiscrete> md = massDisMapper.getAllMassDis();
                for (int i=0; i<md.size(); i++){
                    dIDList.add(md.get(i).getEnterprise_id());
                    div.add(md.get(i).getList());
                }
                break;
            case 2:
                List<ProcIndustry> pi = procInduMapper.getAllProcInd();
                for (int i=0; i<pi.size(); i++){
                    dIDList.add(pi.get(i).getEnterprise_id());
                    div.add(pi.get(i).getList());
                }
                break;
            case 3:
                List<SmeDiscrete> sd = smeDisMapper.getAllSmeDis();
                for (int i=0; i<sd.size(); i++){
                    dIDList.add(sd.get(i).getEnterprise_id());
                    div.add(sd.get(i).getList());
                }
                break;
            case 4:
                List<ServeIndustry> si = servInduMapper.getAllSerInd();
                for (int i=0; i<si.size(); i++){
                    dIDList.add(si.get(i).getEnterprise_id());
                    div.add(si.get(i).getList());
                }
                break;
            case 5:
                List<MixIndustry> mi = mixInduMapper.getAllMixInd();
                for (int i=0; i<mi.size(); i++){
                    dIDList.add(mi.get(i).getEnterprise_id());
                    div.add(mi.get(i).getList());
                }
                break;
            default:
                System.out.println("Error Type!");
                return ;
        }
        tmpFin = finanIndMapper.getAllFinInd();
        for (int i=0; i<tmpFin.size(); i++){
            fin.add(tmpFin.get(i).getList());
        }

        Process p = new Process();
        divList = p.getDiverScore(div, type);
        finList = p.getFinanScore(fin);
        finalList = p.getFinalScore(fin, div);

        for (int i=0; i<dIDList.size(); i++){
            Enterprise ep = enterpriseMapper.getEnterpriseById(dIDList.get(i));
            ep.setDiverScore(divList.get(i));
            enterpriseMapper.updateEnterprise(ep);
        }

        for (int i=0; i<finList.size(); i++){
            Enterprise ep = enterpriseMapper.getEnterpriseById(tmpFin.get(i).getEnterprise_id());
            ep.setFinancialScore(finList.get(i));
            ep.setTotalScore(finalList.get(i));
            enterpriseMapper.updateEnterprise(ep);
        }
    }
}
