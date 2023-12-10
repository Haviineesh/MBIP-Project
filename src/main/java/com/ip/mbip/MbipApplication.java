package com.ip.mbip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ip.mbip.controllers")
public class MbipApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbipApplication.class, args);
		System.out.println("Let's inspect the beans provided by Spring Boot: RUN");
	}

}
