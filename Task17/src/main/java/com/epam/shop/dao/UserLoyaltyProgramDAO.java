package com.epam.shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.shop.model.Product;
import com.epam.shop.model.UserLoyaltyProgram;

public class UserLoyaltyProgramDAO implements ShopDAO<UserLoyaltyProgram> {

    private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(UserLoyaltyProgram loyaltyProgram) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(loyaltyProgram);
		session.getTransaction().commit();	
	}

	public void update(UserLoyaltyProgram loyaltyProgram) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(loyaltyProgram);
		session.getTransaction().commit();	
	}

	public void delete(UserLoyaltyProgram loyaltyProgram) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(loyaltyProgram);
		session.getTransaction().commit();	
	}

	public UserLoyaltyProgram findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		UserLoyaltyProgram loyaltyProgram = (UserLoyaltyProgram) session.load(UserLoyaltyProgram.class, id);
		session.getTransaction().commit();
		return loyaltyProgram;
	}

}
