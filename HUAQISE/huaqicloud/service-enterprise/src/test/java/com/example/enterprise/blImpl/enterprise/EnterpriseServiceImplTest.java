package com.example.enterprise.blImpl.enterprise;

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
 * @Date: 2021/2/26 15:15
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EnterpriseServiceImplTest {

    @Autowired
    EnterpriseServiceImpl enterpriseService;

    @org.junit.Test
    public void login() {
    }

    @org.junit.Test
    public void createNewEnterPrise() {
    }

    @Test
    @Transactional
    @Rollback
    public void deleteEnterPrise() {
        enterpriseService.deleteEnterPrise(2);
    }

    @Test
    @Transactional
    @Rollback
    public void getEnterpriseById() {
        enterpriseService.getEnterpriseById(2);
    }

    @org.junit.Test
    public void updateEnterprise() {
    }

    @org.junit.Test
    public void getEnterpriseImgList() {
    }

    @org.junit.Test
    public void searchEpByKey() {
    }

    @Test
//    @Transactional
//    @Rollback
    public void updateTable() {
        enterpriseService.updateTable(4);
    }

    @Test
    @Transactional
    @Rollback
    public void updatePercent() {
        enterpriseService.updatePercent(4);
    }

    @org.junit.Test
    public void getPercent() {
    }
}