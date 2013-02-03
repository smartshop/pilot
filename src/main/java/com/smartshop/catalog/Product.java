package com.smartshop.catalog;

import java.io.Serializable;
import java.util.List;


public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3204650678728268625L;
	private String Id;
	private String name;
	private String description;
	private String sellingUnit;
	private Double unitPrice;
	private List<Supplier> suppliers;
	private String otherDetails;
	private List<ProductCategory> productCatagories;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSellingUnit() {
		return sellingUnit;
	}
	public void setSellingUnit(String sellingUnit) {
		this.sellingUnit = sellingUnit;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	public List<ProductCategory> getProductCatagories() {
		return productCatagories;
	}
	public void setProductCatagories(List<ProductCategory> productCatagories) {
		this.productCatagories = productCatagories;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

} 