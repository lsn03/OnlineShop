package com.example.springsecurityofficial.dao;

import com.example.springsecurityofficial.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserDAO  {
	Optional<User> findByLogin(String username);
	User createUser(User user);
	void saveUser(User user);
	User findUserByLogin(String userName);
	User doSignIn(User user);
}
