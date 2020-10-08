package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author:
 * @Date: 2020/10/5 14:08
 */
@EnableEurekaServer
@SpringBootApplication
public class EurakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakeApplication.class, args);
    }

}
