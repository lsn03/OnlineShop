package com.example.springsecurityofficial.service;

import com.example.springsecurityofficial.dao.ProductDAO;
import com.example.springsecurityofficial.entity.product.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	@Override
	@Transactional
	public void deleteProduct(Product product) {
		productDAO.deleteProduct(product);
	}
	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}
	
	@Override
	@Transactional
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	
	@Override
	@Transactional
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}
	
	@Override
	public void createProduct(Product product) {
		productDAO.createProduct(product);
	}
}


