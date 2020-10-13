package com.example.enterprise.api.fallback;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.api.EpServiceClient;
import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Date: 2020/10/13 20:16
 */
@Component
public class EpServiceClientFallBack implements EpServiceClient {
    @Override
    public ResponseVO getEnterpriseById(Integer id) {
        return ResponseVO.buildFailure("获取失败");
    }
}
