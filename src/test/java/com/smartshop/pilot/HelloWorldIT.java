package com.smartshop.pilot;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.smartshop.catalog.Email;
import com.smartshop.catalog.PhoneNumber;
import com.smartshop.catalog.Product;
import com.smartshop.catalog.Supplier;

public class HelloWorldIT {
	private static String endpointUrl;
	
	@BeforeClass
	public static void beforeClass() {
		endpointUrl = "http://localhost:8080/";
	}
	
//	@Test
//	public void testPing() throws Exception {
//		WebClient client = WebClient.create(endpointUrl + "/hello/echo/SierraTangoNevada");
//		Response r = client.accept("text/plain").get();
//		assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
//		String value = IOUtils.toString((InputStream)r.getEntity());
//		assertEquals("SierraTangoNevada", value);
//	}
//	
//	@Test
//	public void testJsonRoundtrip() throws Exception {
//		 List<Object> providers = new ArrayList<Object>();
//	    providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
//	    JsonBean inputBean = new JsonBean();
//	    inputBean.setVal1("Maple");
//		WebClient client = WebClient.create(endpointUrl + "/hello/jsonBean", providers);
//		Response r = client.accept("application/json")
//				.type("application/json")
//				.post(inputBean);
//		assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
//		MappingJsonFactory factory = new MappingJsonFactory();
//		JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
//		JsonBean output = parser.readValueAs(JsonBean.class);
//		assertEquals("Maple", output.getVal2());
//	}
	
	@Test
	public void testAddProduct() throws Exception {
		 List<Object> providers = new ArrayList<Object>();
	    providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
	    Product inputBean = new Product();
	    inputBean.setName("Maple");
		WebClient client = WebClient.create(endpointUrl + "pilot/catalog/product", providers);
		Response r = client.accept("application/json")
				.type("application/json")
				.post(inputBean);
		assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
		MappingJsonFactory factory = new MappingJsonFactory();
		JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
		JsonBean output = parser.readValueAs(JsonBean.class);
		assertEquals("Maple", output.getVal2());
	}
	
	@Test
	public void generateJsonSupplier() throws Exception {
		
		Email email = new Email();
		email.setEmail("sarat.duvvuri@gmail.com");
		PhoneNumber number = new PhoneNumber();
//		number.setNumber((long) 8595390161);
		Supplier supplier = new Supplier();
		supplier.setPrimaryEmail(email);
		supplier.setPrimaryPhoneNumber(number);
		
		
		supplier.setName("Lakshmi general Stores");
		
		
	}
}
