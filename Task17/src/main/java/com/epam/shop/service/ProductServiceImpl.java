package com.epam.shop.service;

import com.epam.shop.dao.ShopDAO;
import com.epam.shop.model.Product;

public class ProductServiceImpl implements ShopService<Product> {

	private ShopDAO<Product> productDAO;

	public void setProductDao(ShopDAO<Product> productDAO) {
		this.productDAO = productDAO;
	}

	public void save(Product product) {
		productDAO.save(product);
	}

	public void update(Product product) {
		productDAO.update(product);
	}

	public void delete(Product product) {
		productDAO.delete(product);
	}

	public Product findByCode(int product) {
		return productDAO.findById(product);
	}
	
	public ShopDAO<Product> getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ShopDAO<Product> productDAO) {
		this.productDAO = productDAO;
	}
}