package com.example.springsecurityofficial.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CsrfController {

	@GetMapping("/csrf")
	public Map<String, String> csrf(CsrfToken csrfToken) {
		Map<String, String> response = new HashMap<>();
		response.put("token", csrfToken.getToken());
		return response;
	}
}
