package com.smartshop.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Customer extends EntityObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6252150825854429057L;

	private Long id;
	private String firstName;
	private String lastName;
	private Address billingAddress;
	private Address shippingAddress;
	private Address secondaryShippingAddress;
	private String otherDetails;
	private Email email;


	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Address getSecondaryShippingAddress() {
		return secondaryShippingAddress;
	}
	public void setSecondaryShippingAddress(Address secondaryShippingAddress) {
		this.secondaryShippingAddress = secondaryShippingAddress;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
}
