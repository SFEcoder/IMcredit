package com.example.user.api;

import com.example.common.vo.ResponseVO;
import com.example.user.api.fallback.UserServiceClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author:
 * @Date: 2020/10/5 16:07
 */
@FeignClient(name = "service-user",fallback = UserServiceClientFallBack.class)
public interface UserServiceClient {

    @GetMapping("/api/user/{id}/getUserInfo")
    ResponseVO getUserInfoById(@PathVariable Integer id);
}
