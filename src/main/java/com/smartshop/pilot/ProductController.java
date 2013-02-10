package com.smartshop.pilot;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import com.smartshop.catalog.Product;
import com.smartshop.dao.CatalogService;


public class ProductController {
	
	
	@Autowired
	private CatalogService catalogService;

    
	@GET
	@Produces("application/json")
	@Path("/catalog/product/{productId}")
	@Transactional
	public Product modifyJson(@PathParam("productId") Integer productId) {

		Product product = catalogService.getProductById(productId);
		return product;	
	}

    @POST
    @Produces("application/json")
    @Path("/catalog/product/")
    
    public Product  modifyJson(Product product) {
	catalogService.addOrUpdateProduct(product);
	return product;	
    }




//	@POST
//	@Produces("application/json")
//	@Path("/catalog/product/{productId}")
//	public Response modifyJson(@PathParam("productId") Integer productId) {
//
//		Product product = catalogService.getProductById(productId);
//		return Response.ok().entity(product).build();	
//	}
	
}

