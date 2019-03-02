package com.niiit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niiit.model.Product;
@Repository("productDao")

public interface Productdao {
	public void addProduct(Product c);

	public List<Product> getAllProduct();

	public void deleteProduct(int ProductId);

	public Product getProduct(int ProductId);
	
	public void updateProduct(Product product);
}
