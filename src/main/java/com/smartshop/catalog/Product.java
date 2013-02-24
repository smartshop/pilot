package com.smartshop.catalog;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;







@Entity
public class Product extends EntityObject {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5786598286777576476L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private String name;
	private String description;
	private String sellingUnit;
	private Double unitPrice;
	
	@OneToOne
	private Manufacturer manufacturer;

	@ManyToMany
	private List<Supplier> suppliers;
	private String otherDetails;
	
	@ManyToMany
	private List<ProductCategory> productCatagories;




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


	public boolean add(ProductCategory e) {
		return productCatagories.add(e);
	}


	public Manufacturer getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	
	
	
	

} 