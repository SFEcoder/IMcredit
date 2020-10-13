package com.example.user.blImpl.user;

import com.example.common.cache.RedisCacheClient;
import com.example.common.vo.ResponseVO;
import com.example.user.bl.user.UserService;
import com.example.user.data.user.UserMapper;
import com.example.user.po.User;
import com.example.user.vo.UserForm;
import com.example.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return new ResponseVO<>(null,ACCOUNT_NOT_EXIST);
        }else if(!userForm.getPassword().equals(user.getPassword())){
            return new ResponseVO<>(null,PASSWORD_INCORRECT);
        }else{
            log.info(user.getUsername()+" login successfully with password " +user.getPassword());
            UserVO userVO=new UserVO();
            BeanUtils.copyProperties(user,userVO);
            return new ResponseVO<>(userVO);
        }
    }

    @Override
    public ResponseVO createUser(UserVO userVO) {
        User user=new User();
        BeanUtils.copyProperties(userVO,user);
        user.setAvatarUrl("https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c");
        int effect = userMapper.createNewUser(user);
        if(effect>0){
            return new ResponseVO<>(true);
        }else{
            return new ResponseVO(null,"注册失败");
        }
    }

    @Override
    public Integer updateUser(UserVO userVO) {
        User user=new User();
        BeanUtils.copyProperties(userVO,user);
        return  userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
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
