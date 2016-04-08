package com.epam.shop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	@Id
	@Column(name = "iduser", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="userstatus", nullable = false) 
	private UserStatus userStatus;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_product", joinColumns = { 
			@JoinColumn(name = "iduser", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idproduct", 
					nullable = false, updatable = false) })
	private Set<Product> product = new HashSet<Product>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUserLoyaltyProgram", nullable = false)
	private UserLoyaltyProgram userLoyaltyProgram;
	
	@Embedded
	@AttributeOverrides({
	   @AttributeOverride(name = "avenue", column = @Column(name = "avenue")),
	   @AttributeOverride(name = "city", column = @Column(name = "city")),
	    @AttributeOverride(name = "numberApartment", column = @Column(name = "numberApartment")),
	    @AttributeOverride(name = "numberHouse", column = @Column(name = "numberHouse"))
	})
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")//mappedBy = "iduser", 
	private UserPersonal userPersonal;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	
	public UserLoyaltyProgram getUserLoyaltyProgram() {
		return userLoyaltyProgram;
	}
	public void setUserLoyaltyProgram(UserLoyaltyProgram userLoyaltyProgram) {
		this.userLoyaltyProgram = userLoyaltyProgram;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public UserPersonal getUserPersonal() {
		return userPersonal;
	}
	public void setUserPersonal(UserPersonal userPersonal) {
		this.userPersonal = userPersonal;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
