package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
public class BackendmadadevApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendmadadevApplication.class, args);
		System.out.print(" mihaja app start be");
	}
}
