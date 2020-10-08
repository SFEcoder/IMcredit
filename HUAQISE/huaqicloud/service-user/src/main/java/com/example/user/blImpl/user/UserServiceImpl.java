package com.example.user.blImpl.user;

import com.example.common.cache.RedisCacheClient;
import com.example.user.bl.user.UserService;
import com.example.user.data.user.UserMapper;
import com.example.user.po.User;
import com.example.user.vo.UserForm;
import com.example.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.common.vo.ResponseVO;

/**
 * @Author: zzx
 * @Date: 2020/9/2 11:04
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final static String ACCOUNT_EXIST="该账户已存在";
    private final static String ACCOUNT_NOT_EXIST="该账户不存在，请先创建账户";
    private final static String PASSWORD_INCORRECT="账户密码不正确";

    @Autowired
    private RedisCacheClient redisCacheClient;


    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO login(UserForm userForm) {
        String email=userForm.getEmail();
        User user=userMapper.getUserByEmail(email);
        if(user==null){
            return ResponseVO.buildFailure(ACCOUNT_NOT_EXIST);
        }else if(!userForm.getPassword().equals(user.getPassword())){
            return ResponseVO.buildFailure(PASSWORD_INCORRECT);
        }else{
            log.info(user.getUsername()+" login successfully with password " +user.getPassword());
            UserVO userVO=new UserVO();
            BeanUtils.copyProperties(user,userVO);
            return ResponseVO.buildSuccess(userVO);
        }
    }

    @Override
    public ResponseVO createUser(UserVO userVO) {
        User user=new User();
        BeanUtils.copyProperties(userVO,user);
        user.setAvatarUrl("https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c");
        try {
            userMapper.createNewUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        User user=new User();
        BeanUtils.copyProperties(userVO,user);
        try {
            userMapper.updateUser(user);
            return ResponseVO.buildSuccess("更新成功");
        } catch (Exception e) {
            return ResponseVO.buildFailure("更新失败");
        }

    }

    @Override
    public ResponseVO deleteUserById(Integer id) {
        try {
            userMapper.deleteUserById(id);
            return ResponseVO.buildSuccess("删除成功");
        } catch (Exception e) {
            return ResponseVO.buildFailure("删除失败");
        }

    }

    @Override
    public UserVO getUserInfo(Integer id) {

//        UserVO userVO = (UserVO) redisTemplate.opsForValue().get("user_"+id);
        UserVO userVO = (UserVO) redisCacheClient.get("user_"+id);
        //如果拿不到，就去数据库中查询
        if (userVO==null){
            User user=userMapper.getUserById(id);
            if (user == null) {
                return null;
            }
            userVO=new UserVO();
            BeanUtils.copyProperties(user,userVO);
            //放入缓存中
            System.out.println("redis缓存");
//            redisTemplate.opsForValue().set("user_"+id, userVO, 3000, TimeUnit.SECONDS);
            redisCacheClient.set("user_"+id, userVO, 3000);
        }else {
            System.out.println("redis not 缓存");
        }
        return userVO;
    }
}
