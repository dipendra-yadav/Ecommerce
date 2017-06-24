package com.niit.ecommerce.daoImpl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.domain.Product;


@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Product> products = session.createQuery("from Product").list();
		tx.commit();
		session.flush();
		session.close();
		return products;
	}

	public boolean save(Product product) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(product);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			System.out.println("ProductDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			System.out.println(
					"category=" + product.getCategory().getName() + "& supplier =" + product.getSupplier().getName());
			session.update(product);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("ProductDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Product product) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(product);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public Product getProductByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Product product = (Product) session.createQuery("from Product where
		// id=" + id).uniqueResult();

		Product product = (Product) session.get(Product.class, id);
		tx.commit();
		session.flush();
		session.close();
		return product;

	}

	public Product getProductByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.createQuery("from Product where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return product;

	}

}
