package com.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Cartapplication  /*extendsSpringBootServletInitializer*/ {
	
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(Cartapplication.class); }
	 */
	 
	
	public static void main(String[] args) {
		SpringApplication.run(Cartapplication.class, args);
	}
}