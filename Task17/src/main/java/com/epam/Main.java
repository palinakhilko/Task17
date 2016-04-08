package com.epam;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.shop.model.Address;
import com.epam.shop.model.Product;
import com.epam.shop.model.User;
import com.epam.shop.model.UserLoyaltyProgram;
import com.epam.shop.model.UserPersonal;
import com.epam.shop.model.UserStatus;
import com.epam.shop.service.ShopService;


public class Main {
	public static void main( String[] args )
    {
		System.out.println("start");
    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    	System.out.println("Retrieving services");
    	ShopService<Product> prodService = (ShopService)appContext.getBean("productService");
    	ShopService<UserLoyaltyProgram> loyService = (ShopService)appContext.getBean("loyaltyProgramService");
    	ShopService<User> userService = (ShopService)appContext.getBean("userService");
    	ShopService<UserPersonal> personal = (ShopService)appContext.getBean("personalService");
    	
    	
    	/** insert **/
    	Product product = new Product();
    	product.setModel("63172SHD3");
    	product.setBrand("LG");
    	product.setCategory("TV");
   
    	prodService.save(product);
    	
    	/** select **/
    	System.out.println(product.getIdProduct());
    	Product prod = prodService.findByCode(product.getIdProduct());
    	System.out.println(prod.getIdProduct());
    	
    	
    	Product pro = prodService.findByCode(5);
    	System.out.println(pro.getCategory());
    	prodService.delete(pro);
    	
    	System.out.println("Product element deleted successfully");
    	
    	
    	UserLoyaltyProgram loyaltyProgram = new UserLoyaltyProgram();
    	loyaltyProgram.setName("best");
    	loyaltyProgram.setPercent(0.12);
    	loyService.save(loyaltyProgram);
    	
    	System.out.println("LoyaltyProgram saved, id - " + loyaltyProgram.getId());
    	
    	
    	Address add = new Address();
    	add.setAvenue("Avenue2");
    	add.setCity("City2");
    	add.setNumberApartment(23);
    	add.setNumberHouse(51);
    	User user = new User();
    	user.setName("Name");
    	user.setSurname("SName");
    	user.setUserStatus(UserStatus.ACTIVE);
    	user.setAddress(add);
    	user.setUserLoyaltyProgram(loyaltyProgram);
    	
    	UserPersonal pers = new UserPersonal();
    	pers.setName("service");
    	pers.setPosition("director");
    	pers.setSurname("bla");
    	pers.setUser(user);
    	user.setUserPersonal(pers);
    	
    	Product prod2= new Product();
    	prod2.setBrand("brand");
    	prod2.setCategory("cat");
    	prod2.setModel("vodewl");
    	
    	Set<Product> products = new HashSet<Product>();
    	products.add(prod2);
    	products.add(prod);
    	
    	user.setProduct(products);
    	userService.save(user);
    	System.out.println("User with address, set of products and loy. program saved " +
    			"successfully, id - " + user.getIdUser());
    	
    }
}
