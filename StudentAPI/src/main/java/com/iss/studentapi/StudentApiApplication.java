package com.iss.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class StudentApiApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder webClient() {
        return WebClient.builder().baseUrl("http://localhost:8081");
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }

}
