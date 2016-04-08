package com.epam.shop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;

//@Entity
@Embeddable
//@Table(name = "address")
public class Address implements Serializable {
/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idaddress", unique = true, nullable = false)
	private int id;*/
	
	//@Column(name = "city", nullable = false)
	private String city;
	
	//@Column(name = "avenue", nullable = false)
	private String avenue;
	
	//@Column(name = "numberhouse", nullable = false)
	private Integer numberHouse;
	
	//@Column(name = "numberApartment", nullable = false)
	private Integer numberApartment;
	
	
	@Parent
    protected User user;
	
	public Address() {
	}
	
	public Address(String city, String avenue, int numberHouse, int numberApartment) {
		this.city = city;
		this.avenue = avenue;
		this.numberApartment = numberApartment;
		this.numberHouse = numberHouse;
	}
	
	public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
	
	public Integer getNumberApartment() {
		return numberApartment;
	}
	public void setNumberApartment(Integer numberApartment) {
		this.numberApartment = numberApartment;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public Integer getNumberHouse() {
		return numberHouse;
	}
	public void setNumberHouse(Integer numberHouse) {
		this.numberHouse = numberHouse;
	}
	
	
	public String getAvenue() {
		return avenue;
	}
	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}
}
