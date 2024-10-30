package com.mehmetcil.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mehmetcil.model.Users;
import com.mehmetcil.services.UserService;

@Configuration
public class AppConfig {
	//restcontroller, repository, service, 
	@Bean
	public UserService userService() {
		UserService userService = new UserService();
		
		List<Users> userList = new ArrayList<>();
		userList.add(new Users("Enes"));
		userList.add(new Users("Mehmet"));
		userList.add(new Users("Musa"));

		userService.setUserList(userList);
		
		return userService;
	}

}
