package com.niit.ecommerce.dao;

import java.util.List;

import com.niit.ecommerce.domain.Category;

public interface CategoryDAO {

	public List<Category> list();

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);

	public Category getCategoryByID(int id);

	public Category getCategoryByName(String name);

}
