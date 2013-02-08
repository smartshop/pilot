package com.smartshop.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.smartshop.catalog.Product;

public class CatalogService {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public Product getProductById (Integer productId){
		
		Product product = new Product();
		product.setId(productId);
		product.setName("sampleProduct");
		sessionFactory.getCurrentSession().merge(product);
		
		
		
		return product;
	}

}
