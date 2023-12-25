package com.example.springsecurityofficial.controller;

import java.util.List;
import java.util.Map;

public class ApiResponse {
	private String message;
	private Map<String, List<String>> errors;

	public ApiResponse(String message, Map<String, List<String>> errors) {
		this.message = message;
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, List<String>> getErrors() {
		return errors;
	}
}
