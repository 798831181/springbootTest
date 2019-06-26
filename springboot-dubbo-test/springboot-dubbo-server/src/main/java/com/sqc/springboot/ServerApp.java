package com.sqc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 孙启超
 */
@SpringBootApplication
@ImportResource(locations = "classpath:job.xml")
public class ServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class,args);
    }
}
