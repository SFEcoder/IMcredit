package com.example.enterprise.blImpl.enterprise; 

import com.example.enterprise.bl.enterprise.EnterpriseService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/** 
* EnterpriseServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>10/24/2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EnterpriseServiceImplTest {

    @Autowired
    EnterpriseServiceImpl enterpriseService;

/** 
* 
* Method: login(EnterpriseForm enterpriseForm) 
* 
*/ 
@Test
public void testLogin() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createNewEnterPrise(EnterpriseVO enterpriseVO) 
* 
*/ 
@Test
public void testCreateNewEnterPrise() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteEnterPrise(Integer id) 
* 
*/ 
@Test
public void testDeleteEnterPrise() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getEnterpriseById(Integer id) 
* 
*/ 
@Test
public void testGetEnterpriseById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateEnterprise(EnterpriseVO enterpriseVO) 
* 
*/ 
@Test
public void testUpdateEnterprise() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getEnterpriseImgList() 
* 
*/ 
@Test
public void testGetEnterpriseImgList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchEpByKey(String key) 
* 
*/ 
@Test
public void testSearchEpByKey() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateTable(Integer id) 
* 
*/ 
@Test
public void testUpdateTable() throws Exception { 
//TODO: Test goes here...

    enterpriseService.updateTable(1);
    System.out.println("Over");
}
} 
