package com.iss.marksapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MarksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarksApiApplication.class, args);
    }

}
