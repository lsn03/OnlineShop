package com.example.springsecurityofficial.controller.pages;

import com.example.springsecurityofficial.controller.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsController {
	@GetMapping("/contact_us")
	public String getContactUsPage() {

		return Pages.contactUsPage;
	}
}
