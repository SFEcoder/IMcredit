package com.example.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:
 * @Date: 2020/10/11 19:28
 */
@EnableFeignClients
@SpringBootApplication
public class EnterpriseApplication {
    public static void main(String [] args){
        SpringApplication.run(EnterpriseApplication.class);
    }
}
