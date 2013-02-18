package com.smartshop.catalog;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Supplier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6000346479850349346L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Email primaryEmail;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Email> alternateEmails;
	
	private String otherDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	private PhoneNumber primaryPhoneNumber;
	
	@OneToOne(cascade=CascadeType.ALL)
	private PhoneNumber alternatePhoneNumber;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Product> products;
	
	public boolean add(Product e) {
		return products.add(e);
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	public Email getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(Email primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public List<Email> getAlternateEmails() {
		return alternateEmails;
	}
	public boolean add(Email arg0) {
		return alternateEmails.add(arg0);
	}
	public void setAlternateEmails(List<Email> alternateEmails) {
		this.alternateEmails = alternateEmails;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PhoneNumber getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}
	public void setPrimaryPhoneNumber(PhoneNumber primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}
}
