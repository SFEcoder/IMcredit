package com.example.enterprise.api;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.api.fallback.EpServiceClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author:
 * @Date: 2020/10/13 20:13
 */
@FeignClient(name = "service-enterprise",fallback = EpServiceClientFallBack.class)
public interface EpServiceClient {

    @GetMapping("/api/enterprise/{id}/getEpById")
    ResponseVO getEnterpriseById(@PathVariable Integer id);

}
