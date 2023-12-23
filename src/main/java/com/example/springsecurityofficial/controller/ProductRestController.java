package com.example.springsecurityofficial.controller;

import com.example.springsecurityofficial.entity.product.Product;
import com.example.springsecurityofficial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> showAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable int id) {
		Product product = productService.getProduct(id);
		return product;
	}

	@PostMapping("/products")
	public void addNewProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}

	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
}
