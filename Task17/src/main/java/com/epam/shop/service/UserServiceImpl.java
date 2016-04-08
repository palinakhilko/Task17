package com.epam.shop.service;

import com.epam.shop.dao.ShopDAO;
import com.epam.shop.model.User;

public class UserServiceImpl implements ShopService<User> {

	private ShopDAO<User> userDAO;

	public void setuserDAO(ShopDAO<User> userDAO) {
		this.userDAO = userDAO;
	}

	public void save(User user) {
		userDAO.save(user);
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public User findByCode(int id) {
		return userDAO.findById(id);
	}
	
	public ShopDAO<User> getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(ShopDAO<User> userDAO) {
		this.userDAO = userDAO;
	}
}