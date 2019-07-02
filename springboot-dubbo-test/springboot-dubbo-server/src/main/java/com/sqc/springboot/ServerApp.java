package com.sqc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 孙启超
 */
@SpringBootApplication
@ImportResource(locations = "classpath:job.xml")
@MapperScan("com.sqc.springboot.dao")
@EnableCaching
public class ServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class,args);
    }
}
