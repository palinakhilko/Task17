package com.epam.shop.service;

import com.epam.shop.dao.ShopDAO;
import com.epam.shop.model.UserLoyaltyProgram;

public class LoyaltyServiceImpl implements ShopService<UserLoyaltyProgram> {

	private ShopDAO<UserLoyaltyProgram> loyaltyDAO;

	public ShopDAO<UserLoyaltyProgram> getLoyaltyDAO() {
		return loyaltyDAO;
	}

	public void setLoyaltyDAO(ShopDAO<UserLoyaltyProgram> loyaltyDAO) {
		this.loyaltyDAO = loyaltyDAO;
	}

	public void setloyaltyDAO(ShopDAO<UserLoyaltyProgram> loyaltyDAO) {
		this.loyaltyDAO = loyaltyDAO;
	}

	public void save(UserLoyaltyProgram userLoyaltyProgram) {
		loyaltyDAO.save(userLoyaltyProgram);
	}

	public void update(UserLoyaltyProgram userLoyaltyProgram) {
		loyaltyDAO.update(userLoyaltyProgram);
	}

	public void delete(UserLoyaltyProgram userLoyaltyProgram) {
		loyaltyDAO.delete(userLoyaltyProgram);
	}

	public UserLoyaltyProgram findByCode(int userLoyaltyProgram) {
		return loyaltyDAO.findById(userLoyaltyProgram);
	}
}
