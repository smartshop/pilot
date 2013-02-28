package com.smartshop.pilot;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import com.smartshop.catalog.Address;
import com.smartshop.catalog.Email;
import com.smartshop.catalog.PhoneNumber;
import com.smartshop.catalog.Product;
import com.smartshop.catalog.ProductCategory;
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
		number.setNumber(8595390161L);
		Address address = new Address();
		address.setAddressLine1("123 test st");
		address.setCity("orlando");
		address.setState("Florida");
		address.setZipcode("34747");
		address.setCountry("USA");
		Supplier supplier = new Supplier();
		supplier.setPrimaryEmail(email);
		supplier.setAddress(address);
		supplier.setPrimaryPhoneNumber(number);
		supplier.setName("Lakshmi general Stores");
		System.out.println(toJson(supplier, true));

	}
	
	@Test
	public void generateCategory() throws Exception{
		
		ProductCategory category =  new  ProductCategory();
		category.setName("cereals");
		category.setDescription("all pulses and cereals");
		System.out.println("\n"+toJson(category, true));
		category.setName("forgienFoods");
		category.setDescription("italian");
		System.out.println("\n"+toJson(category, true));
	}
	
	@Test
	public void generateProduct() throws Exception{
		
		Product product =  new  Product();
		product.setName("toor Daal");
		product.setDescription("non-oily");
		product.setSellingUnit("Kilo");
		product.setUnitPrice(36.45);
		System.out.println("\n"+toJson(product, true));
	}
	
    public String toJson(Object pojo, boolean prettyPrint)
    throws Exception {
        StringWriter sw = new StringWriter();
        JsonFactory jf = new JsonFactory();
        JsonGenerator jg = jf.createJsonGenerator(sw);
        ObjectMapper m = new ObjectMapper();
        if (prettyPrint) {
            jg.useDefaultPrettyPrinter();
        }
        m.writeValue(jg, pojo);
        return sw.toString();
    }
}
