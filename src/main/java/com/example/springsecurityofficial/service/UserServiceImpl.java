package com.example.springsecurityofficial.service;

import com.example.springsecurityofficial.dao.UserDAO;
import com.example.springsecurityofficial.entity.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findUserByLogin(username);
		if (user==null){
			throw new UsernameNotFoundException("User with name \""+username+"\" not found");
		}
		System.out.println("UserServiceImpl loadUserByUsername()");
		UserDetails userDetails = org.springframework.security.core.userdetails.User
				.withUsername(user.getLogin())
				.password(user.getPassword())
				.authorities(user.getRole().name())
				.build();
		
		return userDetails;
	}
	
	@Override
	@Transactional
	public boolean isUserExist(User user) {
		return userDAO.findUserByLogin(user.getLogin()) != null;
	}
	
	@Override
	@Transactional
	public void createUser(User user) {
		userDAO.createUser(user);
	}
	
	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}
	
	@Override
	public User doSignIn(User user) {
		User user1 =  userDAO.doSignIn(user);
		return user1;
	}
	
	@Override
	public User getUser(String name) {
		return userDAO.findUserByLogin(name);
	}
}
