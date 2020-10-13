package com.example.user.controller.user;

import com.example.common.vo.ResponseVO;
import com.example.user.bl.user.UserService;
import com.example.user.vo.UserForm;
import com.example.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:
 * @Date: 2020/9/2 20:14
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm userForm){
        return userService.login(userForm);
    }

    @PostMapping("/register")
    public ResponseVO register(@RequestBody UserVO userVO){
        return userService.createUser(userVO);
    }

    @PostMapping("/update")
    public ResponseVO updateUser(@RequestBody UserVO userVO){
        return userService.updateUser(userVO);
    }

    @GetMapping("/delete/{userId}")
    public ResponseVO deleteUser(@PathVariable Integer userId){
        return userService.deleteUserById(userId);
    }

    @GetMapping("/{id}/getUserInfo")
    public ResponseVO getUserInfo(@PathVariable int id) {
        UserVO user = userService.getUserInfo(id);
        if(user==null){
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }

}
