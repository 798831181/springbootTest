package com.sqc.qa;

import com.sqc.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * @author SQC
 */
@SpringBootApplication
public class QaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
