package com.niiit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niiit.model.Category;
@Repository("categoryDao")
public interface Categorydao {
	public void addCategory(Category c);

	public List<Category> getAllCategory();

	public void deleteCategory(int CategoryId);

	public Category getCategory(int CategoryId);
}
