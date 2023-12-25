package com.example.springsecurityofficial.dao;

import com.example.springsecurityofficial.entity.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDAO {
	List<Product> getAllProducts();

	void deleteProduct(Product product);

	void deleteProduct(int product);

	void updateProduct(Product product);

	Product getProduct(int id);

	void createProduct(Product product);
}
