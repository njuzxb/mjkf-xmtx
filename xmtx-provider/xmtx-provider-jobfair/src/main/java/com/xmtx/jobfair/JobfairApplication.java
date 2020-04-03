package com.xmtx.jobfair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xmtx")
@EnableCaching // 开启缓存
public class JobfairApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobfairApplication.class, args);
    }

}
