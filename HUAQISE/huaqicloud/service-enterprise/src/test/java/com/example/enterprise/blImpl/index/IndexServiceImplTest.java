package com.example.enterprise.blImpl.index;

import com.example.enterprise.blImpl.enterprise.EnterpriseServiceImpl;
import com.example.enterprise.vo.EnterpriseTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @Author: Owen
 * @Date: 2021/2/26 19:56
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IndexServiceImplTest {

    @Autowired
    IndexServiceImpl indexService;
    @Autowired
    EnterpriseServiceImpl enterpriseService;

    @Test
    @Transactional
    @Rollback
    public void addEnterpriseTarget() {
        // 17 25 26 18 21
        // mass proc sme serv mix
        Double[] div1 = {0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1}; //17
        Double[] div5 = {0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1}; //21
        Double[] div2 = {0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1}; //25
        Double[] div4 = {0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1}; //18
        Double[] div3 = {0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1}; //26
        Double[] fin = {0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1}; //18
        EnterpriseTarget enterpriseTarget = new EnterpriseTarget(div1, fin);
        indexService.addEnterpriseTarget(1, enterpriseTarget);
    }

    @Test
    public void updateEnterpriseFinanTarget() {
    }

    @Test
    public void updateEnterpriseDiverTarget() {
    }

    @Test
    public void getEnterpriseTarget() {
    }

    @Test
    public void getAnaly() {
    }

    @Test
    @Transactional
    @Rollback
    public void getGradeAllList() {
        Integer id = 2;
        Double[] result = indexService.getGradeAllList(id);
        assertArrayEquals(new Double[]{80.0,90.0,70.0,60.0}, result);
    }

    @Test
    @Transactional
    @Rollback
    public void getFinancialDisplayList(){

        enterpriseService.updatePercent(2);

        indexService.getFinancialDisplayList(2);
    }

    @Test
    @Transactional
    @Rollback
    public void getDebtDisplayList(){

        enterpriseService.updatePercent(2);

        indexService.getDebtDisplayList(2);
    }

    @Test
    @Transactional
    @Rollback
    public void getDevPhraseNum(){
        Integer[] result = indexService.getDevPhraseNum();
        assertEquals(3, result.length);
    }

    @Test
    @Transactional
    @Rollback
    public void getAbilityIndexList(){
        enterpriseService.updatePercent(2);
        indexService.getAbilityIndexList(2);
    }

    @Test
    @Transactional
    @Rollback
    public void getGainAbilityIndexList(){
        enterpriseService.updatePercent(2);
        indexService.getGainAbilityIndexList(2);
    }

    @Test
    @Transactional
    @Rollback
    public void getOperationAbilityIndexList(){
        enterpriseService.updatePercent(2);
        Double[] result = indexService.getOperationAbilityIndexList(2);
        assertEquals(10, result.length);
    }

    @Test
    @Transactional
    @Rollback
    public void getDiverGradeList(){
        Double[] result = indexService.getDiverGradeList(2);
    }

    @Test
    @Transactional
    @Rollback
    public void getDiverFirstIndexList(){
        enterpriseService.updatePercent(2);
        Double[] result = indexService.getDiverFirstIndexList(2);
        assertEquals(8,result.length);
    }

    @Test
    @Transactional
    @Rollback
    public void getDiverGongYingLianList(){

        enterpriseService.updatePercent(2);
        Double[] result = indexService.getDiverGongYingLianList(2);

        assertEquals(10, result.length);
    }

    @Test
    @Transactional
    @Rollback
    public void getDiverXingZhengList(){
        enterpriseService.updatePercent(2);
        Double[] result = indexService.getDiverXingZhengList(2);

        assertEquals(8, result.length);
    }

    @Test
    @Transactional
    @Rollback
    public void getDiverInvestmentList(){
        enterpriseService.updatePercent(2);
        Double[] result = indexService.getDiverInvestmentList(2);

        assertEquals(2, result.length);
    }

    @Test
    @Transactional
    @Rollback
    public void getDiverZenZhiList(){
        enterpriseService.updatePercent(2);
        Double[] result = indexService.getDiverZenZhiList(2);

        assertEquals(8, result.length);
    }

}