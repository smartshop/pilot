package com.smartshop.pilot;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.smartshop.catalog.Address;


public class HelloWorld {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        return input;
    }

    @POST
    @Produces("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input1) {
	input1.setVal2(input1.getVal1());
	return Response.ok().entity(input1).build();
    }
}

