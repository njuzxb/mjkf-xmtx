package com.xmtx.jobfairComment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@MapperScan("com.xmtx.jobfairComment.repository")
@SpringBootApplication
@EnableDiscoveryClient
public class JobCommentProviderApplication {

    public static void main(String[] args){
        SpringApplication.run(JobCommentProviderApplication.class, args);
    }
}
