package com.epam.shop.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epam.shop.model.Product;

public class ProductDAO implements ShopDAO<Product>{
	
    private SessionFactory sessionFactory;
	
	public void save(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
	}

	public void update(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();	
	}

	public void delete(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();	
	}

	public Product findById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.load(Product.class, id);
		session.getTransaction().commit();
		return product;
	}

    public SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
}
