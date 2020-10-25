package com.example.enterprise.blImpl.index;

import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.bl.index.IndexService;
import com.example.enterprise.blImpl.enterprise.EnterpriseServiceImpl;
import com.example.enterprise.dao.index.*;
import com.example.enterprise.po.index.financial.FinancialIndex;
import com.example.enterprise.po.index.integrate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Date: 2020/10/24 16:33
 * @Description 在这里写更新所有参评企业的评分，不需要实现indexservice中的接口，作为工具方法使用
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    EnterpriseServiceImpl enterpriseServiceImpl;
    @Autowired
    MassDisMapper massDisMapper;
    @Autowired
    MixInduMapper mixInduMapper;
    @Autowired
    ProcInduMapper procInduMapper;
    @Autowired
    ServInduMapper servInduMapper;
    @Autowired
    SmeDisMapper smeDisMapper;
    @Autowired
    FinanIndMapper finanIndMapper;

    public Integer addEnterpriseTarget(Integer id, Double[] div, Double[] fin){

        int effect = 0;
        switch (div.length) {
            case 17:
                //mass
                MassDiscrete md = new MassDiscrete(id, div);
                effect = massDisMapper.insertMassDis(md);
                break;
            case 21:
                // mix
                MixIndustry mi = new MixIndustry(id, div);
                effect = mixInduMapper.insertMixIndu(mi);
                break;
            case 25:
                // process
                ProcIndustry pi = new ProcIndustry(id, div);
                effect = procInduMapper.insertProcIndu(pi);
                break;
            case 18:
                // service
                ServeIndustry si = new ServeIndustry(id, div);
                effect = servInduMapper.insertServIndu(si);
                break;
            case 26:
                // sme dis
                SmeDiscrete sd = new SmeDiscrete(id, div);
                effect = smeDisMapper.insertSmeDis(sd);
                break;
            default:
                System.out.println("Invalid Array!");
                return 0;
        }
        if (effect == 0) {
            System.out.println("Error Insertion on DiverTable");
            return 0;
        }

        FinancialIndex fi = new FinancialIndex(id, fin);
        effect = finanIndMapper.insertFinanInd(fi);

        if (effect == 0) {
            System.out.println("Error Insertion on FinanTable");
            return 0;
        }

        // 自动刷新Enterprise表中的三项分数
        enterpriseServiceImpl.updateTable(id);

        return 1;
    }

    public Integer updateEnterpriseFinanTarget(Integer id, Double[] fin){

        int effect = finanIndMapper.deleteFinanById(id);
        if (effect == 0){
            System.out.println("error deletion");
            return 0;
        }

        FinancialIndex fi = new FinancialIndex(id, fin);
        effect = finanIndMapper.insertFinanInd(fi);
        if (effect == 0){
            System.out.println("error insertion");
            return 0;
        }

        // 自动刷新Enterprise表中的三项分数
        enterpriseServiceImpl.updateTable(id);

        return 1;
    }

    public Integer updateEnterpriseDiverTarget(Integer id, Double[] div){

        int effect = 0;
        switch (div.length) {
            case 17:
                //mass
                massDisMapper.deleteDiverById(id);
                MassDiscrete md = new MassDiscrete(id, div);
                effect = massDisMapper.insertMassDis(md);
                break;
            case 21:
                // mix
                mixInduMapper.deleteDiverById(id);
                MixIndustry mi = new MixIndustry(id, div);
                effect = mixInduMapper.insertMixIndu(mi);
                break;
            case 25:
                // process
                procInduMapper.deleteDiverById(id);
                ProcIndustry pi = new ProcIndustry(id, div);
                effect = procInduMapper.insertProcIndu(pi);
                break;
            case 18:
                // service
                servInduMapper.deleteDiverById(id);
                ServeIndustry si = new ServeIndustry(id, div);
                effect = servInduMapper.insertServIndu(si);
                break;
            case 26:
                // sme dis
                smeDisMapper.deleteDiverById(id);
                SmeDiscrete sd = new SmeDiscrete(id, div);
                effect = smeDisMapper.insertSmeDis(sd);
                break;
            default:
                System.out.println("Invalid Array!");
                return 0;
        }

        // 自动刷新Enterprise表中的三项分数
        enterpriseServiceImpl.updateTable(id);

        return 1;
    }



}
