package com.example.springsecurityofficial.dao;

import com.example.springsecurityofficial.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDAO {
	void createUser(User user);
	void saveUser(User user);
	User findUserByName(String userName);
	
	User doSignIn(User user);
}
