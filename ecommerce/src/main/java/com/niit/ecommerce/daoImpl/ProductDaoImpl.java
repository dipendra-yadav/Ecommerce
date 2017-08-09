package com.niit.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
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

	Logger log = Logger.getLogger(ProductDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		List<Product> products = null;
		try {
			log.info("listAll products  starts***");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			products = session.createQuery("from Product").list();
			tx.commit();
			session.flush();
			session.close();
			log.info("listAll products  finished***");
		} catch (Exception e) {
			log.error("listAll products Exception  occured"+e);

		}
		return products;
	}

	public boolean save(Product product) {

		try {
			log.info("Product Save starts***");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(product);
			tx.commit();
			session.flush();
			session.close();
			log.info("Product  Save finsihed***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			log.error("Save product Exception  occured"+e);
			return false;
		}
	}

	public boolean update(Product product) {
		try {

			log.info("Product Update starts***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("category=" + product.getCategory().getName() + "& supplier =" + product.getSupplier().getName());
			session.update(product);
			session.getTransaction().commit();
			session.flush();
			session.close();

			log.info("Product Update finished***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			log.error("Update product Exception  occured"+e);
			return false;
		}

	}

	public boolean delete(Product product) {

		try {
			log.info("Product delete Starts***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(product);
			session.getTransaction().commit();
			session.flush();
			session.close();
			log.info("Product delete finished***");
			return true;
		}

		catch (Exception e) {
			
			log.error("delete product Exception  occured"+e);
			return false;
		}

	}

	public Product getProductByID(int id) {
		log.info("Product getProductByID Starts***");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Product product = (Product) session.createQuery("from Product where
		// id=" + id).uniqueResult();

		Product product = (Product) session.get(Product.class, id);
		tx.commit();
		session.flush();
		session.close();
		log.info("Product getProductByID finished***");
        
        return product;

	}

	public Product getProductByName(String name) {
		log.info("Product getProductByName Starts***");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.createQuery("from Product where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		log.info("Product getProductByName finsihed***");
		return product;

	}

}
