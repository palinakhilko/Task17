package com.epam.shop.service;

import com.epam.shop.dao.ShopDAO;
import com.epam.shop.model.UserPersonal;

public class UserPersonalServiceImpl implements ShopService<UserPersonal> {

	private ShopDAO<UserPersonal> userPersonalDAO;

	public void save(UserPersonal user) {
		userPersonalDAO.save(user);
	}

	public void update(UserPersonal user) {
		userPersonalDAO.update(user);
	}

	public void delete(UserPersonal user) {
		userPersonalDAO.delete(user);
	}

	public UserPersonal findByCode(int id) {
		return userPersonalDAO.findById(id);
	}
	
	public ShopDAO<UserPersonal> getUserPersonalDAO() {
		return userPersonalDAO;
	}

	public void setUserPersonalDAO(ShopDAO<UserPersonal> userPersonalDAO) {
		this.userPersonalDAO = userPersonalDAO;
	}
}