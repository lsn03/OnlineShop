package com.example.springsecurityofficial.controller;

import com.example.springsecurityofficial.ViewNames;
import com.example.springsecurityofficial.entity.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavBarController {
	
	@GetMapping("/")
	public String getIndexPage(){
		return ViewNames.indexPage;
	}
	
	@GetMapping("/shopping_cart")
	public String getShoppingCartPage(){
		return ViewNames.shoppingCartPage;
	}
	
	
	@GetMapping("/login")
	public String getLoginPage(Model model){
		model.addAttribute("user",new User());
		return ViewNames.loginPage;
	}
	@GetMapping("/signup")
	public String getSignUpPage(Model model){
		model.addAttribute("user", new User());
		return ViewNames.registrationPage;
	}
	@GetMapping("/catalog")
	public String getCatalogPage(){
		return ViewNames.catalogPage;
	}
	@GetMapping("/contact_us")
	public String getContactUsPage(){
		
		return ViewNames.contactUsPage;
	}
	@GetMapping("/payment")
	public String getPaymentPage(){
		return ViewNames.paymentPage;
	}
	
}
