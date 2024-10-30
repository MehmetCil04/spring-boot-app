package com.mehmetcil.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mehmetcil.config.AppConfig;

public class LoginService {
	// user listesine ihtiyacım var.
	public void login() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
	}
	

}
