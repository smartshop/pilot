package com.smartshop.pilot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;


import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;


import com.smartshop.catalog.Address;
import com.smartshop.catalog.Product;
import com.smartshop.catalog.ProductCategory;
import com.smartshop.catalog.Supplier;
import com.smartshop.dao.CatalogGenerator;
import com.smartshop.dao.CatalogService;

@Controller
public class CatalogController {
	
	
	@Autowired
	private CatalogService catalogService;

	@Autowired
	private SessionFactory sessionFactory;
    
	@GET
	@Produces("application/json")
	@Path("/catalog/product/{productId}")
	@Transactional
	public Product getProductById(@PathParam("productId") Integer productId) {

		Product product = catalogService.getProductById(productId);
		return product;	
	}

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/catalog/product/")
    public Product  addProduct(Product product) {
    	
	catalogService.addOrUpdateProduct(product);
	
	return product;	
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/catalog/productCategory/")
    public ProductCategory  addProductCategory(ProductCategory productCategory) {
    	
	catalogService.addOrUpdateProduct(productCategory);
	
	return productCategory;	
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/catalog/address/")
    public Address  createAddress(Address address) {
    	
	catalogService.addOrUpdateProduct(address);
	
	return address;	
    }

	@POST
	@Produces("application/json")
	@Path("/catalog/supplier/")
	public Supplier modifyJson(Supplier supplier) {

		catalogService.addOrUpdateProduct(supplier);
		
		return supplier;
	}
    

}

