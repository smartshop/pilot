package com.smartshop.pilot;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.smartshop.catalog.Address;
import com.smartshop.dao.CatalogGenerator;
import com.smartshop.dao.CatalogService;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;


/**
 *  File upload service to upload files using RESTFUL services. 
 *  Author: Ananth Durai
 */
@Controller
public class BulkCatalogController {


	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private CatalogGenerator catalogGenerator;

	@POST
	@Path("/catalog/uploadAddressList")
	@Produces("application/json")	
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Transactional
	public List uploadFile(List<Attachment> attachments) {
		
		List addresses = null;
		for(Attachment attr : attachments) {
			DataHandler handler = attr.getDataHandler();
			MultivaluedMap map = attr.getHeaders();
			File file =new File(getFileName(map));
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
				addresses = catalogGenerator.loadAddresses(file, Address.class);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		catalogService.addList(addresses);
		return addresses;
	}

	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}
	
}
