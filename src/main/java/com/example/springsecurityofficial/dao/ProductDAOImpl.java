package com.example.springsecurityofficial.dao;

import com.example.springsecurityofficial.entity.product.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Product> getAllProducts() {
		
		List<Product> allProducts = entityManager.createQuery(
				"from Product", Product.class
		).getResultList();
		
		return allProducts;
	}
	
	@Override
	public void deleteProduct(Product product) {
		
		entityManager.remove(product);
	}
	
	@Override
	public void deleteProduct(int id) {
		Product product = getProduct(id);
		entityManager.remove(product);
	}
	
	@Override
	public void updateProduct(Product product) {
		
		entityManager.merge(product);
	}
	
	@Override
	public Product getProduct(int id) {
		
		Product product = (Product) entityManager.find(Product.class,id);
		return product;
	}
	
	@Override
	public void createProduct(Product product) {
	
	entityManager.persist(product);
	}
}
