package com.example.springsecurityofficial.controller.pages;

import com.example.springsecurityofficial.controller.Pages;
import com.example.springsecurityofficial.entity.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInUpController {

	@GetMapping("/login")
	public String getLoginPage(Model model, Authentication authentication) {
		if (checkAuthenthification(authentication)) {
			return "redirect:/";
		}
		model.addAttribute("user", new User());
		return Pages.loginPage;
	}

	@GetMapping("/signup")
	public String getSignUpPage(Model model, Authentication authentication) {

		if (checkAuthenthification(authentication)) {
			return "redirect:/";
		}
		model.addAttribute("user", new User());
		return Pages.registrationPage;
	}

	private static boolean checkAuthenthification(Authentication authentication) {
		return authentication != null && authentication.isAuthenticated();
	}


}
