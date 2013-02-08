package com.smartshop.pilot;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartshop.catalog.Address;
import com.smartshop.catalog.Product;
import com.smartshop.dao.CatalogService;


public class ProductController {
	
	
	@Autowired
	private CatalogService catalogService;

    @GET
    @Path("/echo/{input}")
    @Produces("application/json")
    public Product ping(@PathParam("input") Integer input) {
//        return input;
    	Product product = catalogService.getProductById(input);
		return product;	
    }
    
	@GET
	@Produces("application/json")
	@Path("/catalog/product/{productId}")
	public Product modifyJson(@PathParam("productId") Integer productId) {

		Product product = catalogService.getProductById(productId);
		return product;	
	}
//
//    @POST
//    @Produces("application/json")
//    @Path("/jsonBean")
//    public Response modifyJson(JsonBean input1) {
//	input1.setVal2(input1.getVal1());
//	return Response.ok().entity(input1).build();	
//    }
//    
//    private CatalogService catalogService;
//
//
//	@Autowired
//	public void setCatalogService(CatalogService catalogService) {
//		this.catalogService = catalogService;
//	}


//	@POST
//	@Produces("application/json")
//	@Path("/catalog/product/{productId}")
//	public Response modifyJson(@PathParam("productId") Integer productId) {
//
//		Product product = catalogService.getProductById(productId);
//		return Response.ok().entity(product).build();	
//	}
	
}

