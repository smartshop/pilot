package com.smartshop.pilot;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;


import com.smartshop.catalog.Supplier;
import com.smartshop.dao.CatalogGenerator;
import com.smartshop.dao.CatalogService;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.*;
import java.util.List;


@Controller
public class BulkCatalogController {


	@Autowired
	private CatalogService catalogService;

	@Autowired
	private CatalogGenerator catalogGenerator;


	@POST
	@Path("/catalog/{entityType}/")
	@Produces("application/json")	
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Transactional
	public List uploadSimple(@PathParam("entityType") String entityType,List<Attachment> attachments) {

		List addresses = null;
		File file =lodFileData(entityType, attachments);
		addresses = catalogGenerator.loadFileData(file, entityType);
		catalogService.addList(addresses);
		return addresses;
	}

	@PUT
	@Path("/catalog/{supplierId}/{entityType}/")
	@Produces("application/json")	
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Transactional
	public Supplier uploadSupplierSpecificData(@PathParam("entityType") String entityType,@PathParam("supplierId") Long supplierId,List<Attachment> attachments) {

		File file = lodFileData(entityType, attachments);
		Supplier supplier = catalogService.getSupplierById(supplierId);
		if(supplier==null){
			throw new WebApplicationException(404);
		}
		List products = catalogGenerator.loadFileData(file, entityType);
		catalogService.addList(products);
		supplier.addProducts(products);
		return supplier;
	}


	private File lodFileData(String entityType ,List<Attachment> attachments){
		File file =new File(entityType);
		for(Attachment attr : attachments) {
			DataHandler handler = attr.getDataHandler();
			MultivaluedMap map = attr.getHeaders();

			try {
				InputStream stream = handler.getInputStream();

				OutputStream out = new FileOutputStream(file);

				int read = 0;
				byte[] bytes = new byte[1024];
				while ((read = stream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				stream.close();
				out.flush();
				out.close();

			} catch(Exception e) {
				e.printStackTrace();
			}

		}
		return file;
	}


}
