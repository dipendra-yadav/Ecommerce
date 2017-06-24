package com.niit.ecommerce.dao;

import java.util.List;

import com.niit.ecommerce.domain.Product;

public interface ProductDAO {

	public List<Product> list();

	public boolean save(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public Product getProductByID(int id);

	public Product getProductByName(String name);
}
