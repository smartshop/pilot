package com.smartshop.dao;

import com.smartshop.catalog.Product;

public class CatalogService {
	
	
	public Product getProductById (Integer productId){
		
		Product product = new Product();
		product.setId(productId);
		product.setName("sampleProduct");
		
		
		return product;
	}

}
