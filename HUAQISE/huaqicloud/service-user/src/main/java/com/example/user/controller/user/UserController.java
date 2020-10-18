package com.example.user.controller.user;

import com.example.common.vo.ResponseVO;
import com.example.user.bl.user.UserService;
import com.example.user.vo.UserForm;
import com.example.user.vo.UserVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:
 * @Date: 2020/9/2 20:14
 */
@RestController
@RequestMapping("/api/user")
@Api(value="/",tags ="用户接口")
public class UserController {
    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ApiImplicitParam(name = "userForm", value = "用户登录信息", required = true ,dataType = "UserForm")
    public ResponseVO login(@RequestBody UserForm userForm){
        return userService.login(userForm);
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    @ApiImplicitParam(name = "userVO", value = "用户注册信息", required = true ,dataType = "UserVO")
    public ResponseVO register(@RequestBody UserVO userVO){
        return userService.createUser(userVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "userVO",value = "用户更新信息",required = true,dataType = "UserVO")
    public ResponseVO updateUser(@RequestBody UserVO userVO){
        int effect = userService.updateUser(userVO);
        if(effect>0){
            return ResponseVO.buildSuccess("更新成功");
        }else{
            return ResponseVO.buildFailure("更新用户信息失败");
        }
    }

    @GetMapping("/delete/{userId}")
    @ApiOperation(value = "删除特定用户")
    @ApiImplicitParam(name = "userId",value = "被删除用户的Id",required = true,dataType = "Integer")
    public ResponseVO deleteUser(@PathVariable Integer userId){
        int effect = userService.deleteUserById(userId);
        if(effect>0){
            return ResponseVO.buildSuccess("删除成功");
        }else{
            return ResponseVO.buildFailure("删除用户信息失败");
        }
    }

    @GetMapping("/{userId}/getUserInfo")
    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "userId",value = "被检索用户的Id",required = true,dataType = "Integer")
    public ResponseVO getUserInfo(@PathVariable Integer userId) {
        UserVO user = userService.getUserInfo(userId);
        if(user==null){
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }else{
            return ResponseVO.buildSuccess(user);
        }

    }


    @GetMapping("/countUserNum")
    @ApiOperation(value = "获取用户数目")
    public ResponseVO countUserNum() {
        return ResponseVO.buildSuccess(userService.getUserNum());
    }


}
