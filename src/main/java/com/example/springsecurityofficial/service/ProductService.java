package com.example.springsecurityofficial.service;

import com.example.springsecurityofficial.entity.product.Product;

import java.util.List;

public interface ProductService {
	public List<Product> getAllProducts();
	public void deleteProduct(Product product);
	public void updateProduct(Product product);
	public Product getProduct(int id);
	public void createProduct(Product product);
}
