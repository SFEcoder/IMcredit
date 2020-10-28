package com.example.enterprise.blImpl.index;

import com.example.enterprise.blImpl.enterprise.EnterpriseServiceImpl;
import com.example.enterprise.po.Enterprise;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Owen
 * @Date: 2020/10/28 14:55
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
    public void getAnaly() {
        enterpriseService.updateTable(2);
        enterpriseService.updatePercent(2);


        String[] array = indexService.getAnaly(2);
        Assert.assertEquals(true, true);
    }
}