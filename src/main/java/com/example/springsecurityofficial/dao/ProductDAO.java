package com.example.springsecurityofficial.dao;

import com.example.springsecurityofficial.entity.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDAO {
	public List<Product> getAllProducts();
	 void deleteProduct(Product product);
	 void deleteProduct(int product);
	public void updateProduct(Product product);
	public Product getProduct(int id);
	public void createProduct(Product product);
}
