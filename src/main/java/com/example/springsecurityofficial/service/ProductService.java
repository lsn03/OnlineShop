package com.example.springsecurityofficial.service;

import com.example.springsecurityofficial.entity.product.Product;

import java.util.List;

public interface ProductService {
	List<Product> getAllProducts();

	void deleteProduct(Product product);

	void deleteProduct(int id);

	void updateProduct(Product product);

	Product getProduct(int id);

	void createProduct(Product product);
}
