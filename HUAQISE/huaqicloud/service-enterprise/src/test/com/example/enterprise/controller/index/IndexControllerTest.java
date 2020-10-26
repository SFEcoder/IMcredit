package com.example.enterprise.controller.index;

import com.example.common.constant.AesKey;
import com.example.common.utils.AesUtil;
import com.example.common.vo.ResponseVO;
import com.example.enterprise.dao.index.FinanIndMapper;
import com.example.enterprise.dao.index.MassDisMapper;
import com.example.enterprise.po.index.financial.FinancialIndex;
import com.example.enterprise.po.index.integrate.MassDiscrete;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @Author: Owen
 * @Date: 2020/10/25 13:49
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerTest {

    @Autowired
    IndexController indexController;

    @Autowired
    FinanIndMapper finanIndMapper;

    @Autowired
    MassDisMapper massDisMapper;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Transactional
    @Rollback
    public void addEnterpriseTarget() {
        Double[] fin = {4.0,0.52,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.5,166.0,2.0,3.0,55.0,1.0};
        Double[] div = {95.0,3.0,1.0,-2.0,1.0,0.0,1.0,30.92,2.0,1.0,1.0,8.0,2.0,1.0,2.0,3.0,2.0};

        ResponseVO rv = indexController.addEnterpriseTarget(1, div, fin);
        Assert.assertEquals(true, rv.getSuccess());
    }

    @Test
    @Transactional
    @Rollback
    public void updateEnterpriseFinanTarget() {
//      Double[] fin = {3.0,0.51,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.5,166.0,2.0,3.0,55.0,1.0};
        Double[] fin = {0.0,0.51,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.5,166.0,2.0,3.0,55.0,1.0};

        ResponseVO rv = indexController.updateEnterpriseFinanTarget(2, fin);
        FinancialIndex fi = finanIndMapper.getFinanByEpId(2);

        Assert.assertEquals(true, rv.getSuccess());
        Assert.assertEquals(0, fi.getTtm(), 0.01);
    }

    @Test
    @Transactional
    @Rollback
    public void updateEnterpriseDiverTarget() {

//      Double[] div = {100.0,4.0,2.0,-5.0,5.0,3.0,3.0,39.43,9.0,1.0,5.0,65.0,3.0,1.0,4.0,4.0,4.0};
        Double[] div = {50.0,4.0,2.0,-5.0,5.0,3.0,3.0,39.43,9.0,1.0,5.0,65.0,3.0,1.0,4.0,4.0,4.0};

        ResponseVO rv = indexController.updateEnterpriseDiverTarget(2, div);
        MassDiscrete md = massDisMapper.getMassDisByEpId(2);

        Assert.assertEquals(true, rv.getSuccess());
        Assert.assertEquals(50, md.getOn_time_delivery_rate(), 0.01);
    }

    @Test
    @Transactional
    @Rollback
    public void getEnterpriseTarget() {

        ResponseVO responseVO = indexController.getEnterpriseTarget(1);

        System.out.println(responseVO.getContent());

        Assert.assertEquals(true, responseVO.getSuccess());
    }
}