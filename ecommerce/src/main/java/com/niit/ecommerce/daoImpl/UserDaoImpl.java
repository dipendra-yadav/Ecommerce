package com.niit.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.dao.UserDAO;
import com.niit.ecommerce.domain.User;
import com.niit.listeners.Log4jUtil;

@Transactional
@Repository
public class UserDaoImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	Logger log = Logger.getLogger(UserDaoImpl.class);

	// List All users
	public List<User> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> users = session.createQuery("from User").list();
		return users;

	}

	// GetUserById
	public User getUser(int id) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			tx.commit();
			session.flush();
			session.close();
			return user;

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// GetUserByName
	public User getUser(String name) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User where name='" + name + "'";

			User user = (User) session.createQuery(hql).uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return user;

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// save user
	public boolean save(User user) {
		try {
			log.info("save starts**********");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			session.save(user);
			log.info("save operation done***********");

			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			log.error("exception occured while  User registration ");
			e.printStackTrace();
			return false;
		}

	}

	// upadating the user
	public boolean update(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(user);
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

	// validate the User
	public boolean validate(String name, String password) {
		// select * from user where id='manu' and password='manu';
		// String hql="from user where id='manu' and password='manu';

		String hql = "from User where name='" + name + "'and password='" + password + "'";
		Session session = sessionFactory.openSession();
		User user = (User) session.createQuery(hql).uniqueResult();
		System.out.println("User retrieved from the Database=\t" + user);
		log.info("User retrieved from the Database=\t" + user);
		if (user == null)
			return false;

		return true;
	}

}
