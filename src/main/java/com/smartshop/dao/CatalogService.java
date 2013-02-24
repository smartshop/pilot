package com.smartshop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartshop.catalog.EntityObject;
import com.smartshop.catalog.Product;
import com.smartshop.catalog.Supplier;

@Repository
public class CatalogService {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private HashMap<String,String> entityMap;


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
	public void addOrUpdateProduct(Object object){

		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	public void addList(List list){

		for(Object object: list){
			addOrUpdateProduct(object);
		}
	}

	@Transactional()
	public Supplier getSupplierById(Long supplierId) {
		List<Supplier> suppliers = sessionFactory.getCurrentSession().createQuery("from Supplier where id = :id ")
				.setLong("id", supplierId).list();
		Supplier supplier=null;
		if(suppliers!=null && !suppliers.isEmpty()){
			supplier = suppliers.get(0);
		}
		return supplier;
	}

	@Transactional()
	public EntityObject getEntityById(String entity, Integer id) {

		EntityObject entityObject=null;
		try {
			String EntityName = Class.forName(entityMap.get(entity)).getSimpleName();


			List<EntityObject> entityObjects = sessionFactory.getCurrentSession().createQuery("from "+EntityName+" where id = :id ")
					.setLong("id", id).list();

			if(entityObjects!=null && !entityObjects.isEmpty()){
				entityObject = entityObjects.get(0);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entityObject; 
	}


}
