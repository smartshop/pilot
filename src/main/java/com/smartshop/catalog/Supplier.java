package com.smartshop.catalog;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Supplier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6000346479850349346L;
	
	@Id
	private Integer id;
	private String name;
	
	@OneToOne
	private Address address;
	private String otherDetails;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	

}
