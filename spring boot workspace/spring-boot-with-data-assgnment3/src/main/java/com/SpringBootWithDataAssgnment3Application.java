package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")  // Enable @Controller, @Service, @Repository 
@EntityScan(basePackages = "com.bean")  			// Enable @Entity annotation 
@EnableJpaRepositories(basePackages = "com.repository")  // enable spring data features 
public class SpringBootWithDataAssgnment3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithDataAssgnment3Application.class, args);
		System.err.println("Spring boot with data up");
	}

}
