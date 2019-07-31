package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;

@EnableAutoConfiguration
@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
@SpringBootApplication
public class BootDemoApplication {
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {

		SpringApplication.run(BootDemoApplication.class, args);
	}

}
