package com.chache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChachingApplication.class, args);
	}

}
