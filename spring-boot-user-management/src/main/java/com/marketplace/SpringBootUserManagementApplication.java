package com.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserManagementApplication.class, args);
		System.out.println("hello");
	}

}