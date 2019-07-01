package com.sqc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(BookConsumerApp.class);

    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
