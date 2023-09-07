package com.example.springsecurityofficial.config;

import com.example.springsecurityofficial.entity.user.User;
import com.example.springsecurityofficial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ds implements UserDetailsService {
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUser(username);
		org.springframework.security.core.userdetails.User.UserBuilder builder = null;
		if(user!=null){
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			builder.roles(user.getRole().name());
			
		}else{
			return null;
		}
		return builder.build();
	}
}
