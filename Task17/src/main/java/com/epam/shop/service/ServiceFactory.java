package com.epam.shop.service;

public class ServiceFactory {

	private LoyaltyServiceImpl loyaltyService= new LoyaltyServiceImpl();
	private ProductServiceImpl productService= new ProductServiceImpl();
	private UserServiceImpl userService= new UserServiceImpl();
	private UserPersonalServiceImpl userPersonalService= new UserPersonalServiceImpl();
	
	
	private static ServiceFactory serviceFactory = new ServiceFactory();
	private ServiceFactory(){}
	
	public  LoyaltyServiceImpl createLoyaltyService(){
		return loyaltyService;
	}
	public  ProductServiceImpl createProductService(){
		return productService;
	}
	public UserPersonalServiceImpl createUserPersonalService(){
		return userPersonalService;
	}
	public UserServiceImpl createUserService(){
		return userService;
	}
	
	public static ServiceFactory createInstance(){
		return serviceFactory;
	
	}	
}