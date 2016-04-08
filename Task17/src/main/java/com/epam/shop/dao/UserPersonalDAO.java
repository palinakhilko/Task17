package com.epam.shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epam.shop.model.UserPersonal;

public class UserPersonalDAO implements ShopDAO<UserPersonal> {

	private SessionFactory sessionFactory;
	
	public void save(UserPersonal user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	public void update(UserPersonal user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

	public void delete(UserPersonal user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}

	public UserPersonal findById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserPersonal user = (UserPersonal) session.load(UserPersonal.class, id);
		session.getTransaction().commit();
		return user;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
