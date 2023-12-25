package com.example.springsecurityofficial.controller.pages;

import com.example.springsecurityofficial.controller.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
	@GetMapping("/payment")
	public String getPaymentPage() {
		return Pages.paymentPage;
	}
}
