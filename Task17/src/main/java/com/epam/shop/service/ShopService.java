package com.epam.shop.service;

public interface ShopService <T extends Object> {

	void save(T obj);
	
	void update(T obj);
	
	void delete(T obj);
	
	T findByCode(int id);
}
