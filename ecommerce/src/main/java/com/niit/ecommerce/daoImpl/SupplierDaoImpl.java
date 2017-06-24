package com.niit.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.domain.Supplier;
import com.niit.ecommerce.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDaoImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	public List<Supplier> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Supplier> suppliers = session.createQuery("from Supplier").list();
		tx.commit();
		session.flush();
		session.close();
		return suppliers;
	}

	public boolean save(Supplier supplier) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(supplier);
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

	public boolean update(Supplier supplier) {
		try {
			System.out.println("SupplierDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("supplier=" + supplier.getSupplier().getName() + "& supplier =" + supplier.getSupplier().getName());
			session.update(supplier);
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

	public boolean delete(Supplier supplier) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(supplier);
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

	public Supplier getSupplierByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Supplier supplier = (Supplier) session.createQuery("from Supplier where
		// id=" + id).uniqueResult();

		Supplier supplier = (Supplier) session.get(Supplier.class, id);
		tx.commit();
		session.flush();
		session.close();
		return supplier;

	}

	public Supplier getSupplierByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Supplier> supplier = (List<Supplier>)session.createQuery("from Supplier where name='" + name + "'").list();
		tx.commit();
		session.flush();
		session.close();
		return  supplier.get(0);

	}

	
}
