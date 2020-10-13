package com.example.user.api.fallback;

import com.example.common.vo.ResponseVO;
import com.example.user.api.UserServiceClient;
import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Date: 2020/10/5 16:09
 */
@Component
public class UserServiceClientFallBack implements UserServiceClient {
    @Override
    public ResponseVO getUserInfoById(Integer id) {
        return ResponseVO.buildFailure("触发熔断");
    }
}
