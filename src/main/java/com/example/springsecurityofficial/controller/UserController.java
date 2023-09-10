package com.example.springsecurityofficial.controller;

import com.example.springsecurityofficial.Pages;
import com.example.springsecurityofficial.entity.user.User;
import com.example.springsecurityofficial.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpServletRequest req, Model model){
		if(result.hasErrors()){
			return Pages.registrationPage;
		}
		
		if(!user.getConfirmPassword().equals(user.getPassword())){
			model.addAttribute("passwordMismatch", true);
			return Pages.registrationPage;
		}
		if(userService.isUserExist(user)){
			model.addAttribute("userExists", true);
			return Pages.registrationPage;
		}
		
		User usercreated = userService.createUser(user);
		
		setUserRegistered(usercreated,req);
		
		System.out.println("UserController: registerUser()\t "+user);
		return "redirect:/";
	}
	
	private void setUserRegistered(User res,HttpServletRequest req){
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(res.getLogin(),res.getPassword(),res.getAuthorities());
		
		Authentication auth = (authToken);
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(auth);
		HttpSession session = req.getSession(true);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,sc);
		
	}
	
	@PostMapping("/signin")
	public String signInUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpServletRequest req){
		if(result.hasErrors()){
			return Pages.loginPage;
		}
		
		User res = userService.doSignIn(user);
		
		
		
		if(res!=null){
			setUserRegistered(res,req);
			System.out.println("UserController: signInUser" + res);
			return "redirect:/";
		}
		System.out.println("UserController: signInUser() NULL \t "+res);
		return Pages.loginPage;
	}
	@GetMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
}
