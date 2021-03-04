package com.example.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Author:
 * @Date: 2020/10/11 19:28
 */
@EnableFeignClients(basePackages = {"com.example"})
@SpringBootApplication(scanBasePackages = {"com.example"})
public class EnterpriseApplication {
    public static void main(String [] args){
        SpringApplication.run(EnterpriseApplication.class);
    }
}
