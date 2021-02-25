package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author:
 * @Date: 2020/10/5 16:19
 */
@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableZuulProxy
@EnableOAuth2Sso
public class ZuulApplication {
    public static void main(String [] args){
        SpringApplication.run(ZuulApplication.class,args);
    }
}
