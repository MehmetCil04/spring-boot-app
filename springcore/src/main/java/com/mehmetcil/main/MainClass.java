package com.mehmetcil.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mehmetcil.config.AppConfig;
import com.mehmetcil.model.Users;
import com.mehmetcil.services.LoginService;
import com.mehmetcil.services.UserService;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		for (Users user : userService.getUserList()) {
			System.out.println(user);
			
		}
		LoginService loginService = new LoginService();
		loginService.login();
		
	}

}
