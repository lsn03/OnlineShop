package com.example.springsecurityofficial.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/admin")
	public String getAdminPanel() {
		return "admin";
	}
}
