package com.epam.shop.dao;

public interface ShopDAO <T extends Object> {

void save(T obj);
	
	void update(T obj);
	
	void delete(T obj);
	
	T findById(int obj);

}
