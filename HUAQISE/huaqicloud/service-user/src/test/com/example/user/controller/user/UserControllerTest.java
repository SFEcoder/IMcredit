package com.example.user.controller.user;

import com.example.common.vo.ResponseVO;
import com.example.user.bl.user.EncryptionService;
import com.example.user.bl.user.UserService;
import com.example.user.data.user.UserMapper;
import com.example.user.po.User;
import com.example.user.vo.UserForm;
import com.example.user.vo.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.mockito.Mockito.*;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @since <pre>10/12/2020</pre>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    UserController userController;
    @Autowired
    UserService userService;
    @Autowired
    EncryptionService encryptionService;
    @Autowired
    UserMapper userMapper;

    private User user;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setEmail("C1@qq.com");
        user.setPassword("123456");
        user.setUserType("Client");
        user.setAvatarUrl("https://pic4");
        user.setPhoneNumber("123456789");
        user.setUsername("客户一号");


    }

    /**
     *
     * Method: login(@RequestBody UserForm userForm)
     *
     */
    @Test
    @Transactional
    @Rollback
    public void testLogin() throws Exception {

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        assert userController.register(userVO).getSuccess();

        UserForm userForm = new UserForm();
        userForm.setEmail(user.getEmail());
        userForm.setPassword(user.getPassword());
        ResponseVO result = userController.login(userForm);
        assert result.getSuccess();

        UserVO user1 = (UserVO) result.getContent();
        Assert.assertEquals(user1.getEmail(), user.getEmail());
        Assert.assertEquals(user1.getPassword(), user.getPassword());
        Assert.assertEquals(user1.getUsername(), user.getUsername());

        // delete duplicate data
        ResponseVO rv = userController.deleteUser(((UserVO) result.getContent()).getId());
        assert rv.getSuccess();
        System.out.println(rv.getMessage());

    }

    /**
     *
     * Method: register(@RequestBody UserVO userVO)
     *
     */
    @Test
    public void testRegister() throws Exception {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        assert userController.register(userVO).getSuccess();   // register

        User user1 = userMapper.getUserByEmail(user.getEmail());
        user.setId(user1.getId());
        Assert.assertEquals(user.getUserType(), user1.getUserType());
        Assert.assertEquals(user.getPhoneNumber(), user1.getPhoneNumber());

        // delete account
        userController.deleteUser(user.getId());

    }

    /**
     *
     * Method: updateUser(@RequestBody UserVO userVO)
     *
     */
    @Test
    public void testUpdateUser() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: deleteUser(@PathVariable Integer userId)
     *
     */
    @Test
    public void testDeleteUser() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: getUserInfo(@PathVariable int id)
     *
     */
    @Test
    public void testGetUserInfo() throws Exception {
//TODO: Test goes here...
    }


}