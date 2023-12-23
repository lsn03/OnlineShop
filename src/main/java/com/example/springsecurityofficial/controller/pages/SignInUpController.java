package com.example.springsecurityofficial.controller.pages;

import com.example.springsecurityofficial.controller.Pages;
import com.example.springsecurityofficial.entity.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInUpController {
	
	@GetMapping("/login")
	public String getLoginPage(Model model){
		model.addAttribute("user",new User());
		return Pages.loginPage;
	}
	@GetMapping("/signup")
	public String getSignUpPage(Model model){
		model.addAttribute("user", new User());
		return Pages.registrationPage;
	}
	
	
	
}
