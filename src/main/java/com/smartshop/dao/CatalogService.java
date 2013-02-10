package com.smartshop.dao;

import java.lang.annotation.Inherited;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartshop.catalog.Product;

@Repository
public class CatalogService {

	@Autowired
	SessionFactory sessionFactory;


	@Transactional()
	public Product getProductById (Integer productId){

		List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product where id = :id ")
				.setInteger("id", productId ).list();
		Product product = null;
		if(products!=null && !products.isEmpty()){
			product = products.get(0);
		}
		return product;
	}
	
	@Transactional
	public void addOrUpdateProduct(Product product){

			sessionFactory.getCurrentSession().merge(product);
	}
	

}
