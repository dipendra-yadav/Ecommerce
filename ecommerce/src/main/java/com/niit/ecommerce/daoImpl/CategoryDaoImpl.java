package com.niit.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.domain.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Category> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Category> category = session.createQuery("from Category").list();
		tx.commit();
		session.flush();
		session.close();
		return category;
	}

	public boolean save(Category category) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(category);
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

	public boolean update(Category category) {
		try {
			System.out.println("CategoryDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("CategoryDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Category category) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(category);
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

	public Category getCategoryByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Product product = (Product) session.createQuery("from Product where
		// id=" + id).uniqueResult();

		Category category = (Category) session.get(Category.class, id);
		tx.commit();
		session.flush();
		session.close();
		return category;

	}

	public Category getCategoryByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Category category = (Category) session.createQuery("from Category where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return category;

	}

}
