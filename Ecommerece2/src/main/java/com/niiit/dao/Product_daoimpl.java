package com.niiit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niiit.model.Product;
@Repository("productDao")
@Transactional
public class Product_daoimpl implements Productdao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product c) {
	sessionFactory.getCurrentSession().saveOrUpdate(c);
	}
	
	public void deleteProduct(int ProductId) {
		Product product = (Product) sessionFactory.getCurrentSession().load(
				Product.class, ProductId);
	if (null != product) {
		this.sessionFactory.getCurrentSession().delete(product);
		}
	}
	
	public Product getProduct(int Productid) {
	return (Product) sessionFactory.getCurrentSession().get(Product.class, Productid);
	}

	@Override
	public List<Product> getAllProduct() {
	return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	
	
	public void updateProduct(Product product) {//product.id=5
		Session session=sessionFactory.getCurrentSession();
		session.update(product);//-> details will get updated in the table
	}
	
}
