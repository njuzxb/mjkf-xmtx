package com.xmtx.jobfair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class jobfairApplication {

    public static void main(String[] args) {
        SpringApplication.run(jobfairApplication.class, args);
    }

}
