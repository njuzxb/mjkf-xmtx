package com.xmtx.webui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xmtx")
public class webuiApplication {

    public static void main(String[] args){
        SpringApplication.run(webuiApplication.class, args);
    }
}
