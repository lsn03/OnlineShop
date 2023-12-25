package com.example.springsecurityofficial.controller.pages;

import com.example.springsecurityofficial.controller.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
	public String getIndexPage() {
		return Pages.indexPage;
	}

	@GetMapping("/index")
	public String getIndexPage2() {
		return Pages.indexPage;
	}
}
