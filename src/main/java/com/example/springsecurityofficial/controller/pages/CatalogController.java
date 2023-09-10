package com.example.springsecurityofficial.controller.pages;

import com.example.springsecurityofficial.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
	@GetMapping("/catalog")
	public String getCatalogPage(){
		return Pages.catalogPage;
	}
}
