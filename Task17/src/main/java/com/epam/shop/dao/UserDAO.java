package com.epam.shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epam.shop.model.User;

public class UserDAO implements ShopDAO<User> {

	private SessionFactory sessionFactory;
	 
	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public void update(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public User findById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.load(User.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
