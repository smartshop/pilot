package com.smartshop.catalog;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;





@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3204650678728268625L;

	@Id
	private Integer id;
	private String name;
	private String description;
	private String sellingUnit;
	private Double unitPrice;
	
	@ManyToMany
	private List<Supplier> suppliers;
	private String otherDetails;
	
//	@ManyToMany
//	private List<ProductCategory> productCatagories;




	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
//	public List<ProductCategory> getProductCatagories() {
//		return productCatagories;
//	}
//	public void setProductCatagories(List<ProductCategory> productCatagories) {
//		this.productCatagories = productCatagories;
//	}

	
	
	
	

} 