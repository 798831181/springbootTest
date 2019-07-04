package com.sqc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孙启超
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BookConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(BookConsumerApp.class);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
