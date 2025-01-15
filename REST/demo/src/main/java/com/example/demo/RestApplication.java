package com.example.demo;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		System.out.println("Running in main, Hello World!");
		SpringApplication.run(RestApplication.class, args);
	}

}
