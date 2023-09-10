package com.example.springsecurityofficial.dao;

import com.example.springsecurityofficial.entity.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class UserDaoImpl implements UserDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void createUser(User user) {
		String userPassword = user.getPassword();
		System.out.println(user);
		user.setPassword(passwordEncoder.encode(userPassword));
		System.out.println(user);
		entityManager.persist(user);
	}
	
	@Override
	@Transactional
	public User findUserByLogin(String userName) {
		User user;
		try{
			user =  entityManager.createQuery(
					"from User where login = :userName ", User.class
			).setParameter("userName",userName).getSingleResult();
		}catch (Exception e){
			user = null;
		}
		return user;
	}
	
	@Override
	public void saveUser(User user) {
	
	}
	
	@Override
	public User doSignIn(User user) {
		try{
		User userfromDatabase =  entityManager.createQuery(
				"from User where login = :userName ", User.class
		).setParameter("userName",user.getLogin()).getSingleResult();
		if( passwordEncoder.matches(
				user.getPassword(),
				userfromDatabase.getPassword())
		)
		{
			return userfromDatabase;
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		
		return null;
		
	}
	
	
}
