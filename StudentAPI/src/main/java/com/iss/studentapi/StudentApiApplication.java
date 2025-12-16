package com.iss.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentApiApplication {

    @Bean
    @LoadBalanced/// crucial
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced /// crucial for calling for the service-Id call
    public WebClient.Builder webClient() {
        return WebClient.builder().baseUrl("http://MARKS-API");
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }

}
