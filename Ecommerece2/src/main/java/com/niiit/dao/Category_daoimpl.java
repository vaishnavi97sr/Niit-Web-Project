package com.niiit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niiit.model.Category;

@Repository("categoryDao")
@Transactional
public class Category_daoimpl implements Categorydao{

	@Autowired
	private SessionFactory sessionFactory;

	public void addCategory(Category c) {
		
	sessionFactory.getCurrentSession().saveOrUpdate(c);
	
	}
	
	
	public void deleteCategory(int CategoryId) {
	Category category = (Category) sessionFactory.getCurrentSession().load(
	Category.class, CategoryId);
	if (null != category) {
		this.sessionFactory.getCurrentSession().delete(category);}
	}
	
	public Category getCategory(int Categoryid) {
	return (Category) sessionFactory.getCurrentSession().get(Category.class, Categoryid);}

	public List<Category> getAllCategory() {
	return sessionFactory.getCurrentSession().createQuery("from Category").list();
	
	}
}
