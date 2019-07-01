package com.sqc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 孙启超
 */
@SpringBootApplication
@MapperScan("com.sqc.springboot.dao")

public class BookServerApp {
    public static void main(String[] args) {
        SpringApplication.run(BookServerApp.class);
    }
}
