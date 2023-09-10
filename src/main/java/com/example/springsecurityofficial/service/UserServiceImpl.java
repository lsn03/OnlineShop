package com.example.springsecurityofficial.service;

import com.example.springsecurityofficial.dao.UserDAO;
import com.example.springsecurityofficial.entity.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("UserServiceImpl loadUserByUsername()" + userDetails);
		return userDetails;
	}
	
	@Override
	@Transactional
	public boolean isUserExist(User user) {
		return userDAO.findUserByLogin(user.getLogin()) != null;
	}
	
	@Override
	@Transactional
	public User createUser(User user) {
		return userDAO.createUser(user);
	}
	
	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}
	
	@Override
	public User doSignIn(User user) {
		User user1 =  userDAO.doSignIn(user);
		System.out.println("UserServiceImpl: doSignIn() "+user1.getId());
		return user1;
	}
	
	@Override
	public User getUser(String name) {
		return userDAO.findUserByLogin(name);
	}
}
