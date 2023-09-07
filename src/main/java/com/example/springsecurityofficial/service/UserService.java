package com.example.springsecurityofficial.service;

import com.example.springsecurityofficial.entity.user.User;

public interface UserService {
	void createUser(User user);
	void saveUser(User user);
	boolean isUserExist(User user);
	User doSignIn (User user);
	User getUser (String name);
}
