package com.smartshop.pilot;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import org.springframework.beans.factory.annotation.Autowired;

import com.smartshop.catalog.Product;
import com.smartshop.dao.CatalogService;

public class CatalogController {

	
	private CatalogService catalogService;


	@Autowired
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}


	@GET
	@Produces("application/json")
	@Path("/catalog/product/{productId}")
	public Product modifyJson(@PathParam("productId") Integer productId) {

		Product product = catalogService.getProductById(productId);
		return product;	
	}
	
}
