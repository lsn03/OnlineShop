package com.example.springsecurityofficial.controller;

import com.example.springsecurityofficial.dao.ProductDAO;
import com.example.springsecurityofficial.entity.product.Product;
import com.example.springsecurityofficial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> showAllProducts(){
		List<Product> products = productService.getAllProducts();
		return products;
	}
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable int id){
		Product product = productService.getProduct(id);
		return product;
	}
}
