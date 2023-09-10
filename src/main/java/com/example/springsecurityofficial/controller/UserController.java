package com.example.springsecurityofficial.controller;

import com.example.springsecurityofficial.ViewNames;
import com.example.springsecurityofficial.entity.user.User;
import com.example.springsecurityofficial.service.SecurityService;
import com.example.springsecurityofficial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user){
		
		if(!user.getConfirmPassword().equals(user.getPassword())){
			return "registration";
		}
		if(userService.isUserExist(user)){
			return "registration";
		}
		System.out.println("UserController: registerUser()\t "+user);
		userService.createUser(user);
		return "redirect:/";
	}
	@PostMapping("/signin")
	public String signInUser(@ModelAttribute("user")User user){
		User res = userService.doSignIn(user);
		
		if(res!=null){
			System.out.println("UserController: signInUser()\t "+user);
			
			return ViewNames.indexPage;
		}
		System.out.println("UserController: signInUser() NULL \t "+user);
		return "redirect:/";
	}
}
