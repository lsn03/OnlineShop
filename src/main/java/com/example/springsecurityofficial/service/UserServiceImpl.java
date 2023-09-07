package com.example.springsecurityofficial.service;

import com.example.springsecurityofficial.dao.UserDAO;
import com.example.springsecurityofficial.entity.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	@Transactional
	public boolean isUserExist(User user) {
		return userDAO.findUserByName(user.getLogin()) != null;
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
		return userDAO.doSignIn(user);
	}
	
	@Override
	public User getUser(String name) {
		return userDAO.findUserByName(name);
	}
}
