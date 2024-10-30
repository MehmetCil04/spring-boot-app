package com.mehmetcil.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"com.mehmetcil"})
@EnableJpaRepositories(basePackages = {"com.mehmetcil"})
@ComponentScan(basePackages = {"com.mehmetcil"})
@SpringBootApplication
public class ExceptionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionManagementApplication.class, args);
	}

}
